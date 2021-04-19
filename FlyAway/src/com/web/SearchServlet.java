package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
import com.dao.FlightSearchDao;


@WebServlet("/SearchFlight")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i = 0;
    Connection con = new ConnectionManagerImpl().getconnection();

    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            i++;
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            String SourceCity= request.getParameter("FromCity");
            String DestinationCity= request.getParameter("ToCity");
            String DepartureDate= request.getParameter("DepartureDate");
            //String ReturningDate= request.getParameter("ReturningDate");
             
            System.out.println(SourceCity);
            System.out.println(DestinationCity);
            System.out.println(DepartureDate);
           // System.out.println(ReturningDate);
            
           // FlightsBean flightsbean = new FlightsBean(); 
           // flightsbean.setDepartureDate(DepartureDate);	
            
            Set<FlightsBean> flights = new HashSet<FlightsBean>();
            FlightSearchDao flightsearchdao = new FlightSearchDao();
            flights = flightsearchdao.getAllSearchFlights(SourceCity, DestinationCity,DepartureDate);
            
            System.out.println("HashSet: " + flights);
            request.setAttribute("filterdata", flights);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/FlightList.jsp");
            rd.forward(request,response);
  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
 

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
