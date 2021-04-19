package com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SourceBean;
import com.dao.SourceDao;


@WebServlet("/SourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SourceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String DeparturePlace = request.getParameter("Departure_place");
		//String ArrivalPlace = request.getParameter("arrival_place");
		
		SourceBean sourcebean = new SourceBean();
		//DestinationBean destinationbean = new DestinationBean();
		sourcebean.setCity(DeparturePlace);
		//destinationbean.setCity(ArrivalPlace);
		
		SourceDao sourcedao = new SourceDao();
		try {
			List<SourceBean> sourceplaces = sourcedao.list();
			request.setAttribute("SourcePlaces", sourceplaces);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
            dispatcher.forward(request, response);
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
	}

}}
