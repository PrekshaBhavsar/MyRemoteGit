package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminLoginBean;
import com.dao.AdminLoginDao;




@WebServlet("/Adminlogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		
		AdminLoginBean adminloginbean = new AdminLoginBean();
		adminloginbean.setUsername(username);
		adminloginbean.setPassword(password);
		
		AdminLoginDao adminlogindao = new AdminLoginDao();
		if(adminlogindao.validate(adminloginbean)) {
			String Adminname = adminlogindao.FindAdminname(adminloginbean);
			
			/*request.setAttribute("Adminname", Adminname);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminSuccess.jsp");
			rd.forward(request, response);*/
			response.sendRedirect("AdminSuccess.jsp");
			}
		else {
			response.sendRedirect("Adminlogin.jsp");
		}
	
	}

}
