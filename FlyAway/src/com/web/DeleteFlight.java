package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.FlightsBean;
import com.dao.CRUDFlightDao;


@WebServlet("/DeleteFlight")
public class DeleteFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteFlight() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        	int Sr_no = Integer.parseInt(request.getParameter("Sr_No"));
        	//System.out.println(Sr_no);

        	FlightsBean flightbean = new FlightsBean();
        	flightbean.setSr_no(Sr_no);
        	
        	
        	CRUDFlightDao crudflightdao = new CRUDFlightDao();
        	boolean isflightdeleted = crudflightdao.DeleteFlight(Sr_no);
        	
        	
        	response.sendRedirect("AdminSuccess.jsp");   	   	
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
