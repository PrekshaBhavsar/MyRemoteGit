package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserSignUpBean;
import com.connection.ConnectionManagerImpl;


public class UserSignUpDao {
	private Connection connection;
	
	public UserSignUpDao() {
		connection = new ConnectionManagerImpl().getconnection();
	}
//------------------------------------------------------------------------------------------------------------	
	public boolean Adduser(UserSignUpBean usersignupbean) {

		
	
		boolean isUserRecordInserted = false;
		String Username = usersignupbean.getUsername();
		String Email = usersignupbean.getEmail();
		String Password = usersignupbean.getPassword();
		
		System.out.println(Username);
		System.out.println(Email);
		System.out.println(Password);
		
		
		String sql = "insert into usersignin values(?,?,?)";
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1,Username);
			preparedstatement.setString(2,Email);
			preparedstatement.setString(3,Password);
			int value = preparedstatement.executeUpdate();
			
			if(value >0) {
				isUserRecordInserted = true;
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
		return isUserRecordInserted;

	}
	

}
