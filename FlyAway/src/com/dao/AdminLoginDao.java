package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminLoginBean;
import com.connection.ConnectionManagerImpl;



public class AdminLoginDao {
	private Connection connection;
	
	public AdminLoginDao(){
		connection = new ConnectionManagerImpl().getconnection();
	}
	public String FindAdminname(AdminLoginBean adminloginbean) {
		String User="";
		String sql = "select Username from adminlogin where Username = ? and Password = ?";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,adminloginbean.getUsername());
			pstmt.setString(2,adminloginbean.getPassword());
			ResultSet rs = pstmt.executeQuery();
		
			while(rs.next()) {	
				
			User = rs.getString(1);
		
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return User;		
	}
//----------------------------------------------------------------------------------------------------	
	public boolean validate(AdminLoginBean adminloginbean) {
	
		boolean status = false;
		String Admin="";
		String sql = "SELECT Username FROM adminlogin where Username = ? and Password = ?";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, adminloginbean.getUsername());
			pstmt.setString(2, adminloginbean.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {	
				
				Admin = rs.getString(1);
			
				}
			if(Admin.isEmpty()) {
				status  = false;
			}
			else {
				status = true;
			}
			
			System.out.println("login status "+ status);
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return status;
	}
//----------------------------------------------------------------------------------------------------		
	public boolean ChangePassword(AdminLoginBean adminloginbean) {
		boolean isPasswordChange = false;
		String Admin= "Admin";
		String NewPassword = adminloginbean.getPassword();
		
		System.out.println("Admin "+ Admin);
		System.out.println("NewPassword "+ NewPassword);	
		String sql = "update adminlogin set Password='"+NewPassword+"' where Username='"+Admin+"'";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);			
			//pstmt.setString(1, adminloginbean.getUsername());
			//pstmt.setString(2, adminloginbean.getPassword());
			//ResultSet rs = pstmt.executeQuery();
			
			int value = pstmt.executeUpdate();
			
			if(value >0) {
				isPasswordChange = true;
			}
				
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return isPasswordChange;
	}
	
}