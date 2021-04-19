package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.FlightsBean;
import com.dao.CRUDFlightDao;


@WebServlet("/UpdateFlight")
public class UpdateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateFlight() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
    		int Sr_no = Integer.parseInt(request.getParameter("getSr_no"));
    		String Time = request.getParameter("Time");
    		String Date = request.getParameter("updatedate");
    		int Price = Integer.parseInt(request.getParameter("UpdatePrice"));
    		System.out.println(Sr_no + " "+Time+" "+Date+" "+Price);



        	FlightsBean flightbean = new FlightsBean();
        	flightbean.setSr_no(Sr_no);
        	flightbean.setTime(Time);
        	flightbean.setDepartureDate(Date);
        	flightbean.setPrice(Price);
        	
        	CRUDFlightDao crudflightdao = new CRUDFlightDao();
        	boolean isflightupdated = crudflightdao.UpdateFlightTime(Sr_no,Time,Date,Price);
        	
        	response.sendRedirect("AdminSuccess.jsp"); 
        	
                
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
