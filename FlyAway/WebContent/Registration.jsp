<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@page import="com.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registrartion</title>
 <link rel="stylesheet" href="style.css">
     <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<style>
body{
    background-image: url("Images/cloud.jpg");
    background-size: cover;
}
#form{
    background-color: #000;
    height:400px;
    width:700px;
    margin:auto;
    padding:20px;
    opacity: 0.7;
}
#form h3{
    border-bottom: 2px solid #3399ff;
    width:210px;
    padding: 5px;
}
::placeholder{
    color:#fff
}
#input #input-group{
    width:300px;
    margin:5px;
    border-top: none;
    border-left: none;
    border-right: none;
    outline: none;
    background: transparent;
    color:#fff
}
#input2 #input-group{
    width:195px;
    margin:5px;
    border-top: none;
    border-left: none;
    border-right: none;
    outline: none;
    background: transparent;
    color:#fff
}
#input3 #input-group{
    margin-left: 50px;
}
#input4 #input-group{
    width:300px;
    margin:5px;
    border-top: none;
    border-left: none;
    border-right: none;
    outline: none;
    background: transparent;
    color:#fff
}
#input4 #input-group1{
    width:615px;
    margin:5px;
    border-top: none;
    border-left: none;
    border-right: none;
    outline: none;
    background: transparent;
    color:#fff
}
#input5 h3{
    border-bottom: 2px solid #3399ff;
    width:220px;
    padding: 5px;
}
#input6 #input-group{
    width:300px;
    margin:5px;
    border-top: none;
    border-left: none;
    border-right: none;
    outline: none;
    background: transparent;
    color:#fff
}
#input6 #input-group1{
    width:615px;
    margin:5px;
    border-top: none;
    border-left: none;
    border-right: none;
    outline: none;
    background: transparent;
    color:#fff
}
</style>
</head>
<body>
		<% 	String Airline = "Prefered"; //defalut value initialization for display at airline dropdwon
			String SourceCity="";
			String DestinationCity="";
			String DepartureDate="";
			String Time ="";
			FlightsBean flightsbean = new FlightsBean();
			String x = request.getAttribute("FlightObject").toString();
			//out.println(x);
			String [] splittedString = request.getAttribute("FlightObject").toString().split("-");
			Airline = splittedString[1];
			//String Flightid = "";
			SourceCity=splittedString[3];
			DestinationCity=splittedString[5];
			DepartureDate=splittedString[9] +"-"+ splittedString[8] +"-"+ splittedString[7];
			Time = splittedString[11];
			
			/*out.println("             ");
			out.println("Airline = "+ Airline);
			out.println("SourceCity = "+ SourceCity);
			out.println("DestinationCity = "+ DestinationCity);
			out.println("DepartureDate = "+ DepartureDate);
			out.println("Time= "+ Time);*/

		%>
		
		
		<div class="container"><!--container-->

        <form class="form-group" action="ToPayment" method="post"><!--form-->
            <h1 class="text-center">Registration</h1>

            <div id="form"><!--form-->
                <h3 class="text-white">Booking Details</h3>

            <div id="input"><!--input-->
                <input type="text" id="input-group" name="From" placeholder="From" value ='<%=SourceCity%>'>
                <input type="text" id="input-group" name="To" placeholder="To"   value ='<%=DestinationCity%>'>
                <input type="text" id="input-group" name="DepartureDate" placeholder="Departure Date" value = '<%=DepartureDate %>'>
                <input type="text" id="input-group" name="DepartureTime" placeholder="Departure Time" value = '<%=Time %>'>
                <select  id="input-group" name='Airline' style="background: black;">
                    <option value="<%=Airline%>"><%=Airline%> Airline</option>
                    <option value="Indogo">IndoGo</option>
                    <option value="AirIndia">AirIndia</option>
                    <option value="SpaceJet">SpaceJet</option>
                </select>
                <select  id="input-group" name='TravelClass' style="background: black;">
                    <option value="Preferred Seating">Preferred Seating</option>
                    <option value="Economy">Economy Class</option>
                    <option value="Business Class">Business Class</option>
                    <option value="First Class">First Class</option>
                </select>
                </div><!--input-->

                <div id="input2"><!--input2-->
                    <input type="number" id="input-group" name="Adult" placeholder="Adult" value="1">
                    <input type="number" id="input-group" name="Children" placeholder="Children(2-11years)" value="0">
                    <input type="number" id="input-group" name="infant" placeholder="infant(under 2years)" value="0">
                </div><!--input2-->

             <%--<div id="input3"><!--input3-->
                    <span id="input-group" class="text-primary">Select Your Fare</span> 
                    <input type="radio" id="input-group" name="r">
                    <label class="text-white" for="input-group">One Way</label>
                    <input type="radio" id="input-group" name="r">
                    <label class="text-white" for="input-group">Round Trip</label>
                </div><!--input3-->--%>  

                <div id="input4"><!--input4-->
                  <%-- <input type="text" id="input-group" placeholder="Return Date">
                    <input type="text" id="input-group" placeholder="Return time">
                    <input type="text" id="input-group1" placeholder="Any Message">--%>  
                </div><!--input4-->

                <div id="input5"><!--input5-->
                    <h3 class="text-white">Personal Details</h3>
                </div><!--input5-->

                <div id="input6"><!--input6-->
                    <input type="text" id="input-group" name="fullname" placeholder="Full Name">
                    <input type="number" id="input-group" name="phonenumber" placeholder="Phone Number">
                    <input type="email" id="input-group1" name="email"placeholder="Email">
                </div><!--input6-->
                <button type="submit" class="btn btn-warning text-white">Submit Form &raquo;</button>
                <%-- <button type="submit" class="btn btn-warning text-white">Submit Form</button>--%>
                
            </div><!--form-->

        </form><!--form-->

    </div><!--container-->
</body>
</html>