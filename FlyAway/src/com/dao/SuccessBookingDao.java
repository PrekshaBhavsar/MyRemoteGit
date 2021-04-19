package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.SuccessBooking;
import com.connection.ConnectionManagerImpl;

public class SuccessBookingDao {
private Connection connection;
	
	public SuccessBookingDao() {
		connection = new ConnectionManagerImpl().getconnection();
	}
//------------------------------------------------------------------------------------------------------------	
	public boolean addEntery(SuccessBooking successbooking) {
		
		boolean isaddEntry = false;
		String sql = "insert into bookingdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, successbooking.getEmail());
			pstmt.setString(2, successbooking.getPhonenumber());
			pstmt.setString(3, successbooking.getFrom());
			pstmt.setString(4, successbooking.getTo());
			pstmt.setString(5, successbooking.getDepartureDate());
			pstmt.setString(6, successbooking.getDepartureTime());
			pstmt.setString(7, successbooking.getAirline());
			pstmt.setString(8, successbooking.getTravelClass());
			pstmt.setString(9, successbooking.getAdult());
			pstmt.setString(10, successbooking.getChildren());
			pstmt.setString(11, successbooking.getInfant());
			pstmt.setString(12, successbooking.getFullname());
			pstmt.setString(13, successbooking.getTicketNo());
			
			int value = pstmt.executeUpdate();
			
			if(value > 0) {
				
				isaddEntry = true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isaddEntry;
	}

}
