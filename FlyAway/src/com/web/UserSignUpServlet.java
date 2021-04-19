package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserSignUpBean;
import com.dao.UserSignUpDao;


@WebServlet("/UserSignUp")
public class UserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserSignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username = request.getParameter("Uname");
		String Email = request.getParameter("email");
		String Password = request.getParameter("psw");
		String Cpassword = request.getParameter("confirmpsw");

		
		if(Password.equals(Cpassword)) {

			
			UserSignUpBean Usersignupbean = new UserSignUpBean();
			Usersignupbean.setUsername(Username);
			Usersignupbean.setEmail(Email);
			Usersignupbean.setPassword(Password);
			
			boolean isNewRecord;
			UserSignUpDao usersignupdao = new UserSignUpDao();
			isNewRecord =usersignupdao.Adduser(Usersignupbean);
			
			if(isNewRecord) {	
				System.out.println("Student record inserted successfully");}
		    else {
		        System.out.println("Student record not inserted");}

			request.setAttribute("username", Username);
			RequestDispatcher rd = request.getRequestDispatcher("/loginSuccess.jsp");
			rd.forward(request, response);			
		}
		else {
			response.sendRedirect("UserSignUp.jsp");		
		}
		

	}

}
