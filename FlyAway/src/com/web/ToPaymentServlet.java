package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SuccessBooking;
import com.dao.SuccessBookingDao;


@WebServlet("/ToPayment")
public class ToPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ToPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String From = request.getParameter("From");
		String To = request.getParameter("To");
		String DepartureDate = request.getParameter("DepartureDate");
		String DepartureTime = request.getParameter("DepartureTime");
		String Airline = request.getParameter("Airline");
		String TravelClass = request.getParameter("TravelClass");
		String Adult = request.getParameter("Adult");
		String Children = request.getParameter("Children");
		String infant = request.getParameter("infant");
		String fullname = request.getParameter("fullname");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String TicketNo = Airline.substring(0, 3) + From.substring(0, 3)+ phonenumber.subSequence(6, 10);
		/*
		System.out.println(From);
		System.out.println(To);
		System.out.println(DepartureDate);
		System.out.println(DepartureTime);
		System.out.println(Airline);
		System.out.println(TravelClass);
		System.out.println(Adult);
		System.out.println(Children);
		System.out.println(infant);
		System.out.println(fullname);
		System.out.println(phonenumber);
		System.out.println(email);
		System.out.println(TicketNo);*/
	
		SuccessBooking successbooking = new SuccessBooking(From,To,DepartureDate,DepartureTime,Airline,TravelClass,
				Adult,Children,infant,fullname,phonenumber,email,TicketNo);
		
		SuccessBookingDao successbokkingdao = new SuccessBookingDao();
		
		boolean isaddEntry = successbokkingdao.addEntery(successbooking);
		
		request.setAttribute("SuccessBookingEntry", successbooking);
		RequestDispatcher rd = request.getRequestDispatcher("/Payment.jsp");
		rd.forward(request, response);
		
		//response.sendRedirect("Payment.jsp");
	}

}
