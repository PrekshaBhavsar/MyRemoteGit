package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserSignInBean;
import com.connection.ConnectionManagerImpl;

public class UserSignInDao {
private Connection connection;

	public UserSignInDao() {
		
		connection = new ConnectionManagerImpl().getconnection();
	}
//------------------------------------------------------------------------------------------------------------	
	public String FindUsername(UserSignInBean usersigninbean) {
		String User="";
		String sql = "select Username from usersignin where Email = ? and Password = ?";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usersigninbean.getEmail());
			pstmt.setString(2, usersigninbean.getPassword());
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
//------------------------------------------------------------------------------------------------------------
	public boolean validate(UserSignInBean usersigninbean) {
		String Searchemail="";
		boolean status = false;
		
		String sql = "select Email from usersignin where Email = ? and Password = ?";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usersigninbean.getEmail());
			pstmt.setString(2, usersigninbean.getPassword());
			
			//System.out.println(usersigninbean.getEmail());
			//System.out.println(usersigninbean.getPassword());	
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
			
				Searchemail = rs.getString(1);
			}
			if(Searchemail.isEmpty()) {
				status  = false;
			}
			else {
				status = true;
			}
			System.out.println("login status "+ status);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return status;

	}
}
