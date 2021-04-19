package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminLoginBean;
import com.dao.AdminLoginDao;


@WebServlet("/AdminChangePassword")
public class AdminChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpsw");
		String confirmpassword = request.getParameter("confirmpsw");
		String chpassword = request.getParameter("ChangePassword");
		
		System.out.println("chpassword  "+ chpassword);
		System.out.println("newpsw  "+ newpassword);
		System.out.println("confirmpsw "+ confirmpassword);
		System.out.println("passwords are equal  "+ newpassword.equals(confirmpassword));
		
		if(newpassword.equals(confirmpassword)) {
			AdminLoginBean adminloginbean = new AdminLoginBean();	
			adminloginbean.setPassword(newpassword);
			
			AdminLoginDao adminlogindao = new AdminLoginDao();
			boolean ispasswordchanged = false;			
			ispasswordchanged = adminlogindao.ChangePassword(adminloginbean);
			System.out.println("Admin Password is changed");
				//out.println("Pass");
			response.sendRedirect("Adminlogin.jsp");
			
		}
		else {
			System.out.println("else");
			
			response.sendRedirect("AdminSuccess.jsp");
		}
		
		
		
	}

}
