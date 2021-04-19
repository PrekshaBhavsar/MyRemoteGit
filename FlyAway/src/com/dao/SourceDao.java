package com.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.connection.*;

import com.bean.SourceBean;


public class SourceDao {
	private Connection connection;
	
	public SourceDao(){
		connection = new ConnectionManagerImpl().getconnection();
	}
//------------------------------------------------------------------------------------------------------------	
	public List<SourceBean> list() throws SQLException {
        List<SourceBean> sourceplaces = new ArrayList<>();
         
        try  {
            String sql = "SELECT * FROM masterdeparturelist ORDER BY City";
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
             
            while (result.next()) {
                int Sr_no = result.getInt(1);
                String AirportName = result.getString("AirportName");
                String City = result.getString("City");
                String State = result.getString("Sate");
                String IATAcode = result.getString("IATAcode");
                SourceBean sourcebean = new SourceBean(Sr_no,City);              
                sourceplaces.add(sourcebean);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return sourceplaces;
	    }
}
