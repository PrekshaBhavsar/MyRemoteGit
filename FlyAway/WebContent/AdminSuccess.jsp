<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.* " %>
<%@page import="com.bean.* " %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>AdminPage</title>
<style>

body{
	background-image: url("Images/cloud.jpg");
	min-height: 380px;
 	/* Center and scale the image nicely */
  	background-position: center;
  	background-repeat: no-repeat;
 	background-size: cover;
  	position: relative;
  	
	}
.addbutton,.SearchFlightbutton{
  background: #fff;
  padding: 10px 20px;
  display:block;
  font-size: 15px;
  font-weight: 500;
  color: #3498db;
  border-color: #3498db;
  border:4px 4px 4px 4px;
  cursor: pointer;
  box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
  text-align:center;
  width:200px;
  height:50px;
}
input.btn.btn-primary.add{
  position: absolute;
  top: 200px;
  left: 400px;
  transform: translate(-50%, -50%);
  padding:10px 30px;
}
input.btn.btn-primary.search{
	position: absolute;
  	top: 200px;
  	left: 600px;
  	transform: translate(-50%, -50%);
  	padding:10px 30px;

}
input.btn.btn-primary.all{
	position: absolute;
  	top: 200px;
  	left: 800px;
  	transform: translate(-50%, -50%);
  	padding:10px 30px;

}
.chbutton{
  position: absolute;
  top: 80px;
  right: 10px;
  transform: translate(-50%, -50%);
}

.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 60px;
  right: 28px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 100px;
  right: 600px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 350px;
  padding: 10px;
  background-color: white;
  
}

.form-container h2{
	  text-align:center;
	  color:coral;
	  text-decoration: underline;
	  border:4px 4px 4px 4px;

}
/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 5px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
.container{
	position: absolute;
    top: 130px;
    right : 320px;
    
      
}
div.row{
	color: slateblue;
    font-weight: bolder;
    font-size:15px;
}
.col-sm select{
	 height:30px;
	 border-radius: 4px;
   	 border-color: aquamarine; 
}

div#Airline.col-sm{
	position: absolute;
	left: 100px;
    

}
div#From.col-sm{
    position: absolute;
    left: 200px;

}
div#To.col-sm{
    position: absolute;
    left: 400px;

}
.col-sm input{
	border-radius: 4px;
   	border-color: aquamarine;
}
.departuredate{

    position: absolute;
    left: 800px;
    
    
}
.departuretime{

    position: absolute;
    left: 1000px;
	
}
div#resulttable.container {
	position:absolute;
	top:170px;
	left:70px;
	text-align: center;
}

.Price{
	position: absolute;
    left: 600px;
    max-width: 100%;
}
a.btn.btn-primary.back{
  position: absolute;
  top: 120px;
  right: 10px;
  transform: translate(-50%, -50%);
  padding:5px 45px;

} 

</style>
</head>
<body>
<jsp:include page="WelcomeAdmin.jsp"/>

	<%-- <a href="AdminChangePassword.jsp"><button type="button" class=""><span>Change Password</span></button></a>
		<button class="open-button" onclick="openForm()">Open Form</button>--%>
		<button class="btn btn-primary chbutton" onclick="openForm()">Change Password</button>
		<a class="btn btn-primary back" href="Home.jsp"><span>SignOut</span></a> 
	<div class="form-popup" id="myForm">
  		<form action="AdminChangePassword" class="form-container" method="post">
    		<h2>Change Password</h2>

    		<label for="oldpassword"><b>Old Password</b></label>
   			<input type="password" placeholder="Old Password" name="oldpassword" required>

    		<label for="newpsw"><b>New Password</b></label>
    		<input type="password" placeholder="New Password" name="newpsw" required>
    		
    		 <label for="confirmpsw"><b>Confirm Password</b></label>
    		<input type="password" placeholder="Confirm Password" name="confirmpsw" required>

    		<input type="submit" class="btn" name="ChangePassword" value ="Change Password">
    		<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  			</form>
	</div>
	
	<form action="CRUDFlight" method="get">
	<div class="container">
	 	<div class="row">
	 			<div class="col-sm" id="Airline">
					<% 
			
			try{
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyawaydb","root","root");
				String sql = "select distinct AirlineName from masterairlineslist";
				PreparedStatement pst = con.prepareStatement(sql);		
				ResultSet rs = pst.executeQuery(sql);
				
				if(rs.next()){
					
					out.println("<tr>");
					out.println("<td>Airline</td>");
					out.println("<br>");
					out.println("<td>");
					out.println("<select name = 'Airline'>");
					
					do{
						String Airline = rs.getString("AirlineName");
						out.println("<option value = '"+Airline +"'>" + Airline + "</option>");
					}
					while(rs.next());
					out.println("</select>");
					rs.close();
					out.println("</td></tr>");
					out.println("<br>");
					
					//out.println("<tr><td colspan=2 align=center><input type=submit value=Search></td></tr>");
				}
				else{
					out.println("<tr>");
				 	out.println("<td colspan=1 align=right>");
					out.println("Sorry table is Empty");
				    out.println("</td>");
					}}
				
					catch(Exception e)
        		{
                 	e.printStackTrace(); // Or System.out.println(e);
        		}		
		%>
			</div>
	 		<div class="col-sm" id="From">
	 			
	<% 
			
			try{
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyawaydb","root","root");
				String sql = "select distinct City from masterdeparturelist";
				PreparedStatement pst = con.prepareStatement(sql);		
				ResultSet rs = pst.executeQuery(sql);
				
				if(rs.next()){
					
					out.println("<tr>");
					out.println("<td>From</td>");
					out.println("<br>");
					out.println("<td>");
					out.println("<select name = 'FromCity'>");
					
					do{
						String Fromcityname = rs.getString("City");
						out.println("<option value = '"+Fromcityname +"'>" + Fromcityname + "</option>");
					}
					while(rs.next());
					out.println("</select>");
					rs.close();
					out.println("</td></tr>");
					out.println("<br>");
					
					//out.println("<tr><td colspan=2 align=center><input type=submit value=Search></td></tr>");
				}
				else{
					out.println("<tr>");
				 	out.println("<td colspan=1 align=right>");
					out.println("Sorry table is Empty");
				    out.println("</td>");
					}}
				
					catch(Exception e)
        		{
                 	e.printStackTrace(); // Or System.out.println(e);
        		}		
		%>
		</div>
		<div class="col-sm" id="To">
		<% 
			
			try{
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyawaydb","root","root");
				String sql = "select distinct City from masterarrivallist ";
				PreparedStatement pst = con.prepareStatement(sql);		
				ResultSet rs = pst.executeQuery(sql);
				
				if(rs.next()){
					
					out.println("<tr>");
					out.println("<td>To</td>");
					out.println("<br>");
					out.println("<td>");
					out.println("<select name = 'ToCity'>");
					
					do{
						String Tocityname = rs.getString("City");
						out.println("<option value = '"+Tocityname +"'>" + Tocityname + "</option>");
					}
					while(rs.next());
					out.println("</select>");
					rs.close();
					out.println("</td></tr>");
					out.println("<br>");
					
					//out.println("<tr><td colspan=2 align=center><input type=submit value=Search></td></tr>");
				}
				else{
					out.println("<tr>");
				 	out.println("<td colspan=1 align=right>");
					out.println("Sorry table is Empty");
				    out.println("</td>");
					}}
				
					catch(Exception e)
        		{
                 	e.printStackTrace(); // Or System.out.println(e);
        		}		
		%>
		</div>		
				<div class="col-sm Price" id="price">
				<tr>Price</tr><br>
				<input type="text" placeholder="Price" name="Price" required>
				</div>
				
				<div class="col-sm departuredate" id="DepartureDateinput">
				<tr>DepartureDate</tr><br>
				<input type="date" placeholder="DepartureDate" name="DepartureDate" required>
				</div>
				
				<div class="col-sm departuretime" id="DepartureTime">
				<tr>Departure Time</tr><br>
				<input type="time" placeholder="DepartureTime" name="DepartureTime" required>
				</div>

		<input type="submit" class="btn btn-primary add" name="submitbutton" Value="Add Flight">
		<input type="submit" class="btn btn-primary search" name="submitbutton" Value="Search Flight">
		<input type="submit" class="btn btn-primary all" name="submitbutton" Value="Get All Flight">

	</form>
	
		
<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>

</body>
</html>