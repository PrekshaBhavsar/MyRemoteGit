<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.bean.FlightsBean" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SearchFlight</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
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
	table {
  		display: table;
		align-content: center;
  		border-collapse: separate;
  		border-spacing: 2px;
  		border-color: gray;
  		overflow-y: visible;
		}
	table.center { 
		margin-left:auto;
	 	margin-right:auto;
	 	margin-top:50px;
	 	
	  } 
	table, th, td {
  			border-collapse: collapse;
  			text-align:center;
		}
	#flightlist th{
		background-color: #76A5AF;
  		color: white;
	}
	#flightlist tr:nth-child(even){
		background-color: #f2f2f2;
		}
	#flightlist tr:nth-child(odd){
		background-color: #f2f2f2;
		}	
	th, td {
  			padding: 10px;
		}
	#flightlist tr:hover {background-color: #ddd;}
	.form-box{
		max-width: 200px;
  		margin: auto;
	}	
	.button span:after {
  		content: '\00bb';
  		position: absolute;
  		opacity: 0;
  		top: 0;
  		right: -20px;
  		transition: 0.5s;
		}

	.button:hover span {
  		padding-right: 25px;
		}

	.button:hover span:after {
  		opacity: 1;
  		right: 0;
		}
	.booknow a{
		border-radius:4px 4px 4px 4px;
		padding:5px;	
		background-color: #FF0000
	}
	.booknow a:hover{	
		background-color: #ddd;
		color :#007bff;
	}
	.back{
		position:absolute;
		left:45%;
		padding:10px 50px;
		color:blue;
		background-color:#F9CB9C;
	}
		
	</style>
</head>
<body>
<jsp:include page="Userlogin.jsp"/>
	<div class="booknow">
	  <form method="get" action="BookTicket">
      <table border ="1" Class ="center" id="flightlist">
         <tr>
          <th><b>Airline</b></th>
          <th><b>Flight id</b></th>
          <th><b>Departure City</b></th>
          <th><b>Arrival City</b></th>
          <th><b>Price</b></th>
          <th><b>DepartureDate</b></th>
          <th><b>Time</b></th>
          <th><b>BookNow</b></th>
         </tr>
         <%Set<FlightsBean> flight = 
        		 (HashSet<FlightsBean>)request.getAttribute("filterdata");
         
        for(FlightsBean f:flight){%>
         	
         	
            <tr>
                <td><%=f.getAirline()%></td>
                <td><%=f.getFlightid() %></td>
                <td><%=f.getSourceCity()%></td>
                <td><%=f.getDestinationCity()%></td>
                <td><%=f.getPrice()%></td>
                <td><%=f.getDepartureDate()%></td>
                <td><%=f.getTime()%></td>
                <td><a class="button" href="BookTicket?Flightid=<%=f.getFlightid()%>"><span>Book now &raquo;</span></a>           
               	<%--<td><button type = "submit" name="bookticket" class="bookbutton"><span>Book Now</span></button>--%>
            </tr>     
            <%}%>
             
        </table>
        </form>      
        	<%-- <div class="form-box">
        	<button type="submit" name="bookticket" class="bookbutton" style="vertical-align:middle"><span>Book Now</span>
        	</div>--%>       
	</div>
	<br>
	<a href="Home.jsp"><button type="button" class="btn btn-primary back"><span>Back</span></button></a>
</body>
</html>