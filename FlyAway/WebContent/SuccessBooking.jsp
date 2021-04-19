<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.SuccessBooking" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket</title>
<link rel="stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">

body,html{
	font-family: Arial, Helvetica, sans-serif;
	background-image: url("Images/cloud.jpg");
	min-height: 380px;

 	/* Center and scale the image nicely */
  	background-position: center;
  	background-repeat: no-repeat;
 	background-size: cover;
  		position: relative;
  	}
.text-center{

    position: fixed;
    left: 40%;
}
table.center {

	position: fixed;
    left: 20%;
    top: 100px;
    width: 50%;
   
	} 
table, th, td {
  	border-collapse: collapse;
  	text-align:left;
  	padding:5px;
  	background-color:#f2f2f2;
	}
tr{
	width:30px;
}	
button.btn.btn-primary.home{
	position: fixed;
    left: 570px;
    top: 550px;

}
h1.text-center{
	color: darkblue;
	position:absolute;
	top:30px;
}	
	

</style>
</head>
<body>
	    <% //SuccessBooking successbooking = new SuccessBooking();
			//String successbooking1 = request.getAttribute("SuccessBookingEntry").toString();
			//out.println(successbooking1);
			String successbooking1 =(String)session.getAttribute("SuccessBookingEntry1");
			
			String [] splittedString = successbooking1.split("-");
			
			String From = splittedString[1];
			String To = splittedString[3];
			String DepartureDate = splittedString[5]+"/"+splittedString[6]+"/"+splittedString[7] ;
			String DepartureTime = splittedString[9];
			String Airline = splittedString[11];
			String TravelClass = splittedString[13];
			String Adult = splittedString[15];
			String Children = splittedString[17];
			String infant = splittedString[19];
			String fullname = splittedString[21];
			String phonenumber = splittedString[23];
			String email = splittedString[25];
			String TicketNo = splittedString[27];
			
			%>
	<div class="details">
	<h1 class="text-center">Ticket</h1>
	<table border=1 class ="center">
	
	  <tr>
    	<th>Name:</th>
    	<td><%=fullname %></td>
  	  </tr>
  	  <tr>
    	<th>Phone Number:</th>
    	<td><%=phonenumber%></td>
  	  </tr>
	  <tr>
    	<th>Email:</th>
    	<td><%=email %></td>
  	  </tr>  	  
	  <tr>
    	<th>Ticket Number:</th>
    	<td><%=TicketNo %></td>
	  <tr>
    	<th>From:</th>
    	<td><%=From %></td>
  	  </tr>   
	  <tr>
    	<th>To:</th>
    	<td><%=To %></td>
  	  </tr>
	  <tr>
    	<th>Adult:</th>
    	<td><%=Adult %></td>
  	  </tr>
	  <tr>
    	<th>Children:</th>
    	<td><%=Children %></td>
  	  </tr>
	  <tr>
    	<th>Infant:</th>
    	<td><%=infant %></td>
  	  </tr>  	    	    	     
	  <tr>
    	<th>Departure Date:</th>
    	<td><%=DepartureDate %></td>
  	  </tr>   
	  <tr>
    	<th>Departure Time:</th>
    	<td><%=DepartureTime %></td>
  	  </tr>
	  <tr>
    	<th>Travel Class:</th>
    	<td><%=TravelClass %></td>
  	  </tr>   	   	
	</table>
	</div>
	<div class="backbutton">
		<a href="Home.jsp"><button type="button" class="btn btn-primary home">Home</button></a>
	</div>
</body>
</html>