package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.bean.FlightsBean;
import com.connection.ConnectionManagerImpl;

public class FlightSearchDao {
	
	private Connection connection;
	
	public FlightSearchDao(){
		connection = new ConnectionManagerImpl().getconnection();
		
	}
//------------------------------------------------------------------------------------------------------------	
	public Set<FlightsBean> getAllSearchFlights(String SourceCity,String DestinationCity,String DepartureDate){
		
		 System.out.println("In getAllSearchFlights method");
		Set<FlightsBean> flights = new HashSet<FlightsBean>();

        try {
    		String sql = "select * from flights where SourceCity = ? and DestinationCity = ? and DepartureDate = ?";
            PreparedStatement pst = connection.prepareStatement(sql);        
            pst.setString(1, SourceCity);
            pst.setString(2, DestinationCity);
            pst.setString(3, DepartureDate);
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
		        	
		        	
		        	FlightsBean flightbean = new FlightsBean(airline, flightid,sourceCity,destinationCity,price, departureDate,time);   			
		        	flights.add(flightbean);
		        	System.out.println(flightbean.getFlightid());
		        	
		        	/*Iterator<FlightsBean> value = flights.iterator();
		        	System.out.println("The iterator values are: ");
		            while (value.hasNext()) {
		                System.out.println(value.next());}*/
			
			 		} 
        		}
			 catch (SQLException e) {		
			 			e.printStackTrace();
			 	}
        
 	return flights;
	}

}
