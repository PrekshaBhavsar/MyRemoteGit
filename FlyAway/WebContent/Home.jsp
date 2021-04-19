<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.* " %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="ISO-8859-1">
<link rel="stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Shrikhand&display=swap" rel="stylesheet">
<title>Home</title>
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
		* {
  		box-sizing: border-box;
		}
		input[type="number"]{
  		/*width: 50%;*/
		}
		h2.logo{
		
		position:absolute;
		left:50%;
		top:50%;
		font-family: 'Shrikhand', cursive;
		font-size:100px;
		text-decoration:underline;
		color:blue;
		
		}
	.booking-form-box{
		border:1px solid #ffffff;
		/*margin:10% auto 0;*/
		padding: 25px;
		border-radius: 5px 5px 5px 5px;
		width: 300px;
		position:absolute;
		top:100px;	
	}
	.booking-form{
		padding : 0 10px 10px;
		font-size:15px;
		color:#ffff;
	}
	.booking-form label{
		margin-bottom:5 px;
		margin-top: 10 px;
		font-size:15px;
		color:#fff;
		
	}
	div.City-select{
		/*width: 100%;
  		min-width: 15ch;
  		max-width: 25ch;
  		border: 1px solid var(--select-border);
  		border-radius: 15px 15px 15px 15px;
  		padding: 0.25em 0.5em;
  		font-size: 1.0rem;
 		cursor: pointer;
  		line-height: 1.1;
  		background-color: #fff;*/
  
		
	}
	.booking-form .input_grp{
		display: inline-block;
		justify-content: space-between;
		}
	.booking-form.input_grp  input[type="date"]{
		width: 250x;
	}
	.booking-form.input_grp  input[type="number"]{
		width: 250x;
	}
	input:placeholder{
	
		color: #fff !important;
	}
	.input wrap{
		display:flex;
		width : 100px;
		justify-content: space-between;
	}
	.form-control{
		font-size : 12px !important;
		border-radius:0 !important;
		color : #000 !important;
		backgound:transperent !important;
		box-shadow: none !important;
	}
	.input::-webkit-inner-spin-button,
	.input::-webkit-outer-spin-button{
	
		-webkit-appearance:none;
			margin: 0;
	}
	.select-date::-webkit-calender-picker-indicator{
		background:transperent !important;
	}
	.custom-select{
		color:#000;
		font-size:12px;
		border:1 px solid #ffff;
		box-shadow: none;
		border-radius:0;
		backgrond:transparent;
	}
	.custom-select option{
		color : #333;
	}
	.flight{
		margin : 30 px; 
		width:100px;
		padding: 9px 0;
		fontsize:12px;
		border:1 px solid #ffff;
		
		box-shadow: none;
		border-radius:0;
	}
	.flight::hover
	{
		background:#ffff !important;
		color: #000 !important;
		transition:0.5s;
		
	}
	select{
	    width: 230px;
    	border: none;
    	padding: 5px;
    	font-size: 12px;
	}
	img.logo{
	    position: absolute;
    	left: 40%;
    	top: 53%;
	
	}

</style>
</head>
<body>
<jsp:include page="Userlogin.jsp"/>
<h2 class="logo">Flyaway</h2>
<img src="Images/logo.jpg" alt="logo" class="logo">
<div class="booking-form-box">
	<form action="SearchFlight" method = "post">

		<div class="booking-form">
			<div class = "City-select">
		<% 
			
			try{
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyawaydb","root","root");
				String sql = "select distinct SourceCity from flights";
				PreparedStatement pst = con.prepareStatement(sql);		
				ResultSet rs = pst.executeQuery(sql);
				
				if(rs.next()){
					
					out.println("<tr>");
					out.println("<td>From</td>");
					out.println("<br>");
					out.println("<td>");
					out.println("<select name = 'FromCity'>");
					
					do{
						String Fromcityname = rs.getString("SourceCity");
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
		
		<% 
			
			try{
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyawaydb","root","root");
				String sql = "select distinct DestinationCity from flights";
				PreparedStatement pst = conn.prepareStatement(sql);		
				ResultSet rs = pst.executeQuery(sql);
				
				if(rs.next()){
					
					out.println("<tr>");
					out.println("<td>To</td>");
					out.println("<br>");
					out.println("<td>");
					out.println("<select name = 'ToCity'>");
					
					do{
						String cityname = rs.getString("DestinationCity");
						out.println("<option value = '"+cityname +"'>" + cityname + "</option>");
					}
					while(rs.next());
					out.println("</select>");
					rs.close();
					out.println("</td></tr>");
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
		<div class="input grp">
				<div class="input wrap">
					<label>Departing</label>
					<input type="date" class="form-control select-date" placeholder="dd-mm-yyyy" value="" size="50" name="DepartureDate">
				</div>
				
				<div class="input wrap">
					<label>Adults</label>
					<input type="number" class="form-control" value="1" size="50">
				</div>
				<div class="input wrap">
					<label>Children</label>
					<input type="number" class="form-control" value="0" size="50">
				</div>
				
				<div class="input wrap">
					<label>Travel Class</label>
					<select class = "custom-select" name="TravelClass">
						<option value="1">Economy Class</option>
						<option value="2">Business Class</option>
					</select>
				</div><br>
				<div class="input wrap">
				<%-- <a href="SearchFlight.jsp"><button type="button" class="btn btn-primary flight">Show Flights</button></a>--%>
				<button type="submit" class="btn btn-primary flight">Show Flights</button>
				</div>
				</div>
		</div>		
				
</form>
</div><!-- booking-form-box -->
</body>
</html>