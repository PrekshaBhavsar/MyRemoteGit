<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.bean.FlightsBean" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
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
		background-color: #CFE2F3;
		border:10px;
		border-color:#0000FF;
	}
	.booknow a:hover{	
		background-color: #ddd;
		color :#007bff;
	}
	.form-popup {
  	display: none;
  	position: fixed;
 	 bottom: 10px;
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
	}
	/* Full-width input fields */
	.form-container input[type=text], .form-container input[type=date],.form-container input[type=time] {
  		width: 99%;
  		padding: 5px;
  		margin: 5px 0 10px 0;
  		border: none;
  		background: #f1f1f1;
		}
	.form-container label{
		margin: 0;
	}	

	/* When the inputs get focus, do something */
	.form-container input[type=text]:focus, .form-container input[type=date]:focus, .form-container input[type=time]:focus {
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
	a#back.btn.btn-primary{
		position:absolute;
		left:45%;
		padding:10px 50px;
		color:blue;
		background-color:#F9CB9C;
	}
	a#back.btn.btn-primary:hover{
		text-decoration:underline;
	}
		
	</style>
</head>
<body>
<div class="booknow">
	  <form method="get" action="">
	  <div class="table-responsive-md" style="overflow:auto;">
      <table border ="1" Class ="center" id="flightlist">
      
         <tr>
          <th><b>Sr No</b></th>
          <th><b>Airline</b></th>
          <th><b>Flight id</b></th>
          <th><b>Source City</b></th>
          <th><b>Destination City</b></th>
          <th><b>Price</b></th>
          <th><b>DepartureDate</b></th>
          <th><b>Time</b></th>
         </tr>
         <%Set<FlightsBean> flight = 
        		 (HashSet<FlightsBean>)request.getAttribute("FlightsData");
         
        for(FlightsBean f:flight){%>
				
            <tr>
            	<td><%=f.getSr_no() %></td>
                <td><%=f.getAirline()%></td>
                <td><%=f.getFlightid() %></td>
                <td><%=f.getSourceCity()%></td>
                <td><%=f.getDestinationCity()%></td>
                <td><%=f.getPrice() %></td>
                <td><%=f.getDepartureDate()%></td>
                <td><%=f.getTime()%></td>
                <td><a class="button" onclick="openForm()" id="update"><span>Update</span></a>
                <input type="hidden" id="hiddenSr_No" name="hiddenSr_No" value ="<%=f.getSr_no() %>">              
                <td><a class="button" href="DeleteFlight?Sr_No=<%=f.getSr_no()%>"><span>Delete</span></a>            
              
            </tr>     
            <%}%>
             
        </table>
       </div>
        <br>
        <a class="btn btn-primary" href="AdminSuccess.jsp" id="back"><span>Back</span></a> 
        </form>
        <div class="form-popup" id="myForm">
  		<form action="UpdateFlight" class="form-container" method="get">
    		<h2>Update Details</h2>
			
			<label><b>Flight No</b></label>

			<input type="text" placeholder="Flight No" name="getSr_no" id="getSr_no" value="">
			
    		<label for="updatetime"><b>Update Time</b></label>
   			<input type="time" placeholder="Time" name="Time">

    		<label for="updatedate"><b>Update Date</b></label>
    		<input type="date" placeholder="updatedate" name="updatedate">
    		
    		 <label for="updatePrice"><b>Update Price</b></label>
    		<input type="text" placeholder="updatePrice" name="UpdatePrice">

    		<input type="submit" class="btn" name="updatedetails" value ="Update">
    		<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  			</form>
	</div>           
	</div>
<script>
function openForm() {
	var SR_NO = document.getElementById("hiddenSr_No").value;
	//document.getElementById("para").innerHTML = SR_NO; -->for readonly in jsp <div id="para"></div>
	document.getElementById("getSr_no").value = SR_NO;
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>	

</body>
</html>