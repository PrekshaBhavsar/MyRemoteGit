package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.FlightsBean;
import com.connection.ConnectionManagerImpl;
import com.dao.CRUDFlightDao;


@WebServlet("/CRUDFlight")
public class CRUDFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 Connection con = new ConnectionManagerImpl().getconnection();

    public CRUDFlightServlet() {
        super();
        System.out.println("In CRUD Flight Method");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String airline = request.getParameter("Airline");
		String SourceCity= request.getParameter("FromCity");
		String DestinationCity= request.getParameter("ToCity");
		int Price= Integer.parseInt(request.getParameter("Price"));
        String DepartureDate= request.getParameter("DepartureDate");
        String Time = request.getParameter("DepartureTime");
		String submitbutton = request.getParameter("submitbutton");

       
        System.out.println(airline);
        System.out.println(SourceCity);
        System.out.println(DestinationCity);
        System.out.println(DepartureDate);
        System.out.println(Time);
        System.out.println(submitbutton);
        System.out.println(Price);
        
        
        if(submitbutton.equals("Search Flight")) {
        	
        	FlightsBean flightbean = new FlightsBean();
        	flightbean.setAirline(airline);
        	flightbean.setSourceCity(SourceCity);
        	flightbean.setDestinationCity(DestinationCity);
        	
        	System.out.println("In search" + flightbean.getAirline());
        	CRUDFlightDao crudflightdao = new CRUDFlightDao();

        	
        	Set<FlightsBean> Seachflights = new HashSet<FlightsBean>();
        	Seachflights = crudflightdao.getAllSearchFlights(SourceCity, DestinationCity);
        	
        	
        	request.setAttribute("FlightsData", Seachflights);
    		RequestDispatcher rd = request.getRequestDispatcher("/CRUDFlights.jsp");
    		rd.forward(request, response); 	
        }
        else if(submitbutton.equals("Add Flight")){
        	String Flightid = airline.substring(0, 2) + SourceCity.substring(0, 2) + DestinationCity.substring(0,2);
        	FlightsBean flightbean = new FlightsBean(airline,Flightid,SourceCity,DestinationCity,Price,DepartureDate,Time);

        	CRUDFlightDao crudflightdao = new CRUDFlightDao();

        	Set<FlightsBean> addflights = new HashSet<FlightsBean>();
        	addflights = crudflightdao.addFlights(flightbean);
        	
        	request.setAttribute("FlightsData", addflights);
    		RequestDispatcher rd = request.getRequestDispatcher("/CRUDFlights.jsp");
    		rd.forward(request, response); 	
        }
        else if(submitbutton.equals("Get All Flight")) {

        	CRUDFlightDao crudflightdao = new CRUDFlightDao();

        	Set<FlightsBean> allflights = new HashSet<FlightsBean>();
        	allflights = crudflightdao.getAllFlights();
        	
        	request.setAttribute("FlightsData", allflights);
    		RequestDispatcher rd = request.getRequestDispatcher("/CRUDFlights.jsp");
    		rd.forward(request, response); 	        	
          	
        }
  
        else {
        		response.sendRedirect("AdminSuccess.jsp");
        }
	}
	catch(Exception e) {
		e.printStackTrace();
	}

}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
