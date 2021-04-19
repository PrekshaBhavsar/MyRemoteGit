package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.FlightsBean;
import com.dao.CRUDFlightDao;

@WebServlet("/BookTicket")
public class BookTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookTicket() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Booking...");
		
		String FlightId = request.getParameter("Flightid");
		System.out.println(FlightId);
		
		FlightsBean flightsbean = new FlightsBean();
		flightsbean.setFlightid(FlightId);
		
		CRUDFlightDao crudflightdao = new CRUDFlightDao();
		
		flightsbean = crudflightdao.SearchFlight(FlightId);
		
		System.out.println(flightsbean.getSourceCity());
		System.out.println(flightsbean.getDestinationCity());
		System.out.println(flightsbean.getDepartureDate());
		System.out.println("----------------------------------");
		request.setAttribute("FlightObject", flightsbean);
		RequestDispatcher rd = request.getRequestDispatcher("/Registration.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
