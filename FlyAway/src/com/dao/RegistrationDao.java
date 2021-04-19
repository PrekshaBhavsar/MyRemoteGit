package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminLoginBean;
import com.bean.RegistrationBean;
import com.connection.ConnectionManagerImpl;

public class RegistrationDao {
	private Connection connection;
	
	public RegistrationDao(){
		connection = new ConnectionManagerImpl().getconnection();
	}
//------------------------------------------------------------------------------------------------------------	
	public boolean validate(RegistrationBean registarionbean) {
	
		boolean status = false;
		
		String sql = "SELECT * FROM userregistation where Username = ? and Password = ?";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, registarionbean.getFirstname());
			pstmt.setString(2, registarionbean.getLastname());
			pstmt.setInt(3, registarionbean.getDd());
			pstmt.setInt(4, registarionbean.getMm());
			pstmt.setInt(5, registarionbean.getYy());
			pstmt.setString(6, registarionbean.getEmail());
			pstmt.setString(7, registarionbean.getGender());
			pstmt.setString(8, registarionbean.getSourceCity());
			pstmt.setString(9, registarionbean.getDestinationCity());
			pstmt.setInt(10, registarionbean.getTravellers());
			pstmt.setString(11, registarionbean.getTravellDate());
			pstmt.setString(12, registarionbean.getFlightNo());
				
			ResultSet rs = pstmt.executeQuery();
			status = rs.next();
			System.out.println("registation status "+ status);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return status;

}
}
