package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminLoginBean;
import com.bean.UserSignInBean;
import com.dao.AdminLoginDao;
import com.dao.UserSignInDao;

@WebServlet("/Userlogin")
public class UserloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public UserloginServlet() {
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Email = request.getParameter("email");
		String password = request.getParameter("psw");	
		
		System.out.println(Email);
		System.out.println(password);
		
		UserSignInBean Usersigninbean = new UserSignInBean();
		Usersigninbean.setEmail(Email);
		Usersigninbean.setPassword(password);
		
		UserSignInDao Usersignindao = new UserSignInDao();
		
		if(Usersignindao.validate(Usersigninbean)) {
			String Username = Usersignindao.FindUsername(Usersigninbean);
			
			request.setAttribute("username", Username);
			RequestDispatcher rd = request.getRequestDispatcher("/loginSuccess.jsp");
			rd.forward(request, response);
			//response.sendRedirect("loginSuccess.jsp");
			}
		else {
			response.sendRedirect("Home.jsp");
		}
	}

}
