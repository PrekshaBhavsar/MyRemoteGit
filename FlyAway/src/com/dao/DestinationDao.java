package com.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.DestinationBean;
import com.bean.SourceBean;
import com.connection.ConnectionManagerImpl;

public class DestinationDao {
private Connection connection;
	
	public DestinationDao(){
		connection = new ConnectionManagerImpl().getconnection();
	}
//----------------------------------------------------------------------------------------------	
	public List<DestinationBean> list() throws SQLException {
        List<DestinationBean> destinationplaces = new ArrayList<>();
         
        try  {
            String sql = "SELECT * FROM masterarrivallist ORDER BY City";
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
             
            while (result.next()) {
                int Sr_no = result.getInt(1);
                String AirportName = result.getString("AirportName");
                String City = result.getString("City");
                String State = result.getString("Sate");
                String IATAcode = result.getString("IATAcode");
                DestinationBean destinationbean = new DestinationBean(Sr_no,City);              
                destinationplaces.add(destinationbean);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return destinationplaces;
	    }

}
