package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.bean.FlightsBean;
import com.connection.ConnectionManagerImpl;


public class CRUDFlightDao {

	private Connection connection;
	
	public CRUDFlightDao() {
		connection = new ConnectionManagerImpl().getconnection();
	}
	
	public FlightsBean SearchFlight(String FlightId) {
		
		String sql = "SELECT Airline,FlightId,SourceCity,DestinationCity,DepartureDate,Time FROM flights where FlightId = ?";
		String Airline ="";
		String Flightid = "";
		String SourceCity="";
		String DestinationCity="";
		String DepartureDate="";
		String Time = "";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, FlightId);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {

				
				Airline = resultset.getString(1);
				Flightid = resultset.getString(2);
				SourceCity = resultset.getString(3);
				DestinationCity = resultset.getString(4);
				DepartureDate = resultset.getString(5);
				Time = resultset.getString(6);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();		
				}
		return new FlightsBean(Airline,Flightid,SourceCity,DestinationCity,DepartureDate,Time);
}
//----------------------------------------------------------------------------------------------------	
	public Set<FlightsBean> getAllSearchFlights(String SourceCity,String DestinationCity){
		
		 System.out.println("In getAllSearchFlights method");
		Set<FlightsBean> flights = new HashSet<FlightsBean>();

       try {
   		String sql = "select * from flights where SourceCity = ? and DestinationCity = ?";
           PreparedStatement pst = connection.prepareStatement(sql);        
           pst.setString(1, SourceCity);
           pst.setString(2, DestinationCity);
			ResultSet rs = pst.executeQuery();
			//System.out.println("Query executes");
			
			 while(rs.next()) {
		        	
				 	int Sr_no = rs.getInt(1);
		        	String airline = rs.getString(2);
		        	String flightid = rs.getString(3);
		        	String sourceCity= rs.getString(4);
		        	String destinationCity= rs.getString(5);
		        	int price= rs.getInt(6);
		        	String departureDate= rs.getString(7);
		        	String time= rs.getString(8);
		        	
		        	
		        	FlightsBean flightbean = new FlightsBean(Sr_no,airline, flightid,sourceCity,destinationCity,price, departureDate,time);   			
		        	flights.add(flightbean);
		        	//System.out.println(flightbean.getFlightid());			
			 		} 
       		}
			 catch (SQLException e) {		
			 			e.printStackTrace();
			}
       
       		return flights;
	}
//------------------------------------------------------------------------------------------------------------------------
	public boolean addFlight(FlightsBean flightbean) {
		System.out.println("in add flight");
		boolean isflightadded = false;
		String airline = flightbean.getAirline();
		String sourceCity= flightbean.getSourceCity();
		String destinationCity=flightbean.getDestinationCity();
		String departureDate=flightbean.getDepartureDate();
		String time = flightbean.getTime();
		String Flightid = airline.substring(0, 2) + sourceCity.substring(0, 2) + destinationCity.substring(0,2);
		int Price = 2000;
		
		String sql = "insert into flights(Airline,FlightId,SourceCity,DestinationCity,Price,DepartureDate,Time) values(?,?,?,?,?,?,?)";	
		try {
			PreparedStatement pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, flightbean.getAirline());
			pstatement.setString(2, Flightid);
			pstatement.setString(3, flightbean.getSourceCity());
			pstatement.setString(4, flightbean.getDestinationCity());
			pstatement.setInt(5, Price);
			pstatement.setString(6, flightbean.getDepartureDate());
			pstatement.setString(7, flightbean.getTime());
			
			int value = pstatement.executeUpdate();
			
			if(value >0) {
				isflightadded = true;
				//System.out.println("Sr_no"+flightbean.getSr_no());
			}
		}
			catch(SQLException e) {
				e.printStackTrace();		
			}

		return isflightadded;
	}
//------------------------------------------------------------------------------------------------------------	
	public Set<FlightsBean> addFlights(FlightsBean flightbean) {
		
		Set<FlightsBean> flights = new HashSet<FlightsBean>();
		boolean isflightadded = false;
		int Sr_no=0;
		String Airline = flightbean.getAirline();
		String SourceCity= flightbean.getSourceCity();
		String DestinationCity=flightbean.getDestinationCity();
		String DepartureDate=flightbean.getDepartureDate();
		String Time = flightbean.getTime();
		String Flightid = flightbean.getFlightid();
		int Price = flightbean.getPrice();
		
		String sql = "insert into flights(Airline,FlightId,SourceCity,DestinationCity,Price,DepartureDate,Time) values(?,?,?,?,?,?,?)";	
		try {
			PreparedStatement pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, flightbean.getAirline());
			pstatement.setString(2, flightbean.getFlightid());
			pstatement.setString(3, flightbean.getSourceCity());
			pstatement.setString(4, flightbean.getDestinationCity());
			pstatement.setInt(5, flightbean.getPrice());
			pstatement.setString(6, flightbean.getDepartureDate());
			pstatement.setString(7, flightbean.getTime());
			//ResultSet resultset = pstatement.executeQuery();
			
			int value = pstatement.executeUpdate();
			
			if(value > 0) {
				
				//String sql1 = "SELECT LAST_INSERT_ID()";
				FlightsBean flightsbean = new FlightsBean(Sr_no,Airline,Flightid,SourceCity,DestinationCity,Price,DepartureDate,Time);
				flights.add(flightsbean);							
			}
			
		}
			catch(SQLException e) {
				e.printStackTrace();		
				}

		return flights;
	}

//------------------------------------------------------------------------------------------------------------------------------------	
	public boolean UpdateFlightTime(int Sr_No,String Time,String Date,int Price) {
		boolean isFlightUpdated = false;

		String sql = "UPDATE flights SET Price=?,DepartureDate=?,Time=? WHERE Sr_No =?";
		try {
			PreparedStatement pstatement = connection.prepareStatement(sql);
			pstatement.setInt(1,Price);
			pstatement.setString(2,Date);
			pstatement.setString(3,Time);
			pstatement.setInt(4,Sr_No);
			//ResultSet resultset = pstatement.executeQuery();
			
			int value = pstatement.executeUpdate();
			
			if(value >0) {
				 isFlightUpdated = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();		
			}
		
		return  isFlightUpdated;
	}

	public boolean DeleteFlight(int Sr_No) {
		boolean isFlightDeleted = false;
		
		System.out.println(Sr_No);
		String sql = "delete from flights where Sr_No=?";
		try {
			PreparedStatement pstatement = connection.prepareStatement(sql);
			pstatement.setInt(1,Sr_No);
			//ResultSet resultset = pstatement.executeQuery();
			
			int value = pstatement.executeUpdate();
			
			if(value >0) {
				isFlightDeleted = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();		
			}
		
		return isFlightDeleted;
	}
//----------------------------------------------------------------------------------------------------------
	public Set<FlightsBean> getAllFlights() {
		
		Set<FlightsBean> flights = new HashSet<>();
		System.out.println("in get all method");

		String sql = "select * from flights";
		try {
			PreparedStatement pstatement = connection.prepareStatement(sql);
			ResultSet resultset = pstatement.executeQuery();
			   while(resultset.next()) {

				int Sr_No = resultset.getInt(1);
				String Airline = resultset.getString(2);
				String Flightid = resultset.getString(3);
				String SourceCity = resultset.getString(4);
				String DestinationCity = resultset.getString(5);
				int Price = resultset.getInt(6);
				String DepartureDate = resultset.getString(7);
				String Time = resultset.getString(8);
				FlightsBean flightsbean = new FlightsBean(Sr_No,Airline,Flightid,SourceCity,DestinationCity,Price,DepartureDate,Time);
				//System.out.println(flightsbean);
				flights.add(flightsbean);
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return flights;
	}
}
