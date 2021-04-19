package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl implements ConnectionManager {
	private String dbURL = "jdbc:mysql://localhost:3306/flyawaydb";
	private String dbUname = "root";
	private String dbPassword = "root";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver) {
		
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getconnection() {
		Connection connection = null;
		try {
		Class.forName(dbDriver);
		connection = DriverManager.getConnection(dbURL,dbUname,dbPassword);
		System.out.println("Connected");
		}
		catch(ClassNotFoundException ex){
			ex.printStackTrace();
		 }
		catch(SQLException ex){
			ex.printStackTrace();
	}
		return connection;
	}	

}
