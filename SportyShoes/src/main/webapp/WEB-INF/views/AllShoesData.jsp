<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<style>
.form-popup {
	display: none;
	position: fixed;
	bottom: 50px;
	right: 600px;
	border: 3px solid #f1f1f1;
	z-index: 9;
}
.form-popup.Report{
	position: fixed;
	bottom: 200px;
	right: 600px;

}
/* Add styles to the form container */
.form-container {
	max-width: 350px;
	padding: 10px;
	background-color: white;
}

.form-container h2 {
	text-align: center;
	color: coral;
	text-decoration: underline;
}
/* Full-width input fields */
.form-container input[type=text], .form-container input[type=date]
	{
	width: 100%;
	padding: 3px;
	margin: 5px 0 10px 0;
    border-color: deepskyblue;
    background-color: aliceblue;
    border-radius: 5px;

}
.form-container select{
	padding: 3px;
	margin: 5px 0 10px 0;
	width: 100%;
    border-color: deepskyblue;
    background-color: aliceblue;
    border-radius: 5px;
}	

.form-container select:focus{
		width: 100%;
}
.form-container label {
	margin: 0;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=date]:focus,
	.form-container input[type=time]:focus {
	background-color: #ddd;
	outline: none;
}

/* Set a style for the submit/*/
.form-container .btn {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
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

a#back.btn.btn-primary {
	position: absolute;
	left: 45%;
	padding: 10px 50px;
	color: blue;
	background-color: #F9CB9C;
}

a#back.btn.btn-primary:hover {
	text-decoration: underline;
}
a.fbutton,a.ubutton,a.Rbutton,a.Abutton{
    background-color: steelblue;
    color: aliceblue;
    padding: 5px;
    border: 1px;
    border-radius: 4px;
}
input.date{
  width: 150px;
}
h5.admin{
    text-decoration: underline;
	color: darkblue;
    position: absolute;
    right: 100px;
    top:5px;
}
i.fa.fa-plus-circle.fa-3x{
    color: darkblue;
    position: absolute;
    left: 40px;
}
i.fa.fa-user-circle-o.fa-2x{
    color: darkblue;
    position: absolute;
    right: 30px;
}
/*.dropdown-toggle::after {
       content: none;
    }*/
a#droplink.nav-link.dropdown-toggle{
	position: absolute;
    right: 30px;
}    

</style>
</head>
<body>
<h5 class="admin">Welcome,Admin</h5>

<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" id="droplink">
 <i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i></a>
 <div class="dropdown-menu dropdown-menu-right">
 <a href="/sportyshoes/AdminChangePassword" class="dropdown-item">ChangePassword</a>
 <a href="/sportyshoes/Home" class="dropdown-item">Logout</a>
 </div>

<br><br>

<hr>

<div class="container">
		<div class="row">
			<div class="col-md-auto">
				<form action="/sportyshoes/filterByGender" method="post">
					Gender: 
					<select id="fgender" name="fgender">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
					<button type="submit" id="gfilter">Filter</button>
				</form>
			</div>
			<div class="col-md-auto">
				<form action="/sportyshoes/filterByColor" method="post">
					Color: <select id="fcolor" name="fcolor">
						<option value="Grey">Grey</option>
						<option value="Green">Green</option>
						<option value="Blue">Blue</option>
						<option value="Black">Black</option>
					</select>
					<button type="submit" id="cfilter">Filter</button>
				</form>
			</div>
			<div class="col-md-auto">
				<form action="/sportyshoes/filterByBrand" method="post">
					Brand: <select id="fbrand" name="fbrand">
						<option value="Puma">Puma</option>
						<option value="sketcher">sketcher</option>
						<option value="Adidas">Adidas</option>
						<option value="Bata">Bata</option>
					</select>
					<button type="submit" id="bfilter">Filter</button>
				</form>
			</div>
			<div class="col-md-auto">
				<form action="/sportyshoes/filterByPurchase" method="post">
					Purchased: <select id="fpurchased" name="fpurchased">
						<option value="No">No</option>
						<option value="Yes">Yes</option>
					</select>
					<button type="submit" id="bfilter">Filter</button>
				</form>
			</div>
			<div class="col-md-auto">
				<form action="/sportyshoes/filterByDate" method="post">
					Date: <input name="fdate" type="date" id="fdate" class="date">
					<button type="submit" id="dfilter">Filter</button>
				</form>
			</div>
		</div>
	</div>
	<hr>
	<div class="container">
		<div class="row justify-content-md-center">
	<div class="col-md-auto">
			<a class="fbutton" href="/sportyshoes/AllShoesData">Get all Entry</a>
		</div>
		<div class="col-md-auto">
			<a class="ubutton" href="/sportyshoes/AllUser">Get all User </a>
	    </div>
	    <div class="col-md-auto">
			<!--  <a class="Abutton" href="/sportyshoes/filterByAll?Gender=${fgender}&Color=${fcolor}&Brand=${fbrand}&Ispurchased=${fpurchased}&Date=${fdate}">Filter By All</a>
			<a class="Abutton" id="AllFilter" href="/sportyshoes/filterByAll?Gender=${jGender}&Color=${fcolor}&Brand=${fbrand}&Ispurchased=${fpurchased}&Date=${fdate}">Filter By All</a>-->
	    </div>
	    <div class="col-md-auto">
			<a class="Rbutton" onclick ="ReportopenForm()" id="report">Get Purchase Report for selected date</a>
	    </div>
	</div>
	</div>
	<hr>
<br>
<!--  <a class="addbutton" onclick="AddopenForm()" id="addbutton">Add a Shoe</a>-->
	<a class="addbutton" onclick="AddopenForm()" id="addbutton">
	<i class="fa fa-plus-circle fa-3x" aria-hidden="true"></i></a>
	<div class="container">
		<table class="table">
			<caption>All Shoes List are</caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>Size</th>
					<th>color</th>
					<th>Gender</th>
					<th>Brand</th>
					<th>Date</th>
					<th>IsPurchased</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${AllShoes}" var="Shoe">
					<tr>
						<td>${Shoe.id}</td>
						<td>${Shoe.size}</td>
						<td>${Shoe.color}</td>
						<td>${Shoe.gender}</td>
						<td>${Shoe.brand}</td>
						<td>${Shoe.purchasedate}</td>
						<td>${Shoe.ispurchased}</td>
						<td><a type="button" class="btn btn-success" onclick="openForm()" id="update">Update</a>
						<input type="hidden" id="hiddenSr_No" name="hiddenSr_No" value ="${Shoe.id}">
						<td><a type="button" class="btn btn-warning" href="/sportyshoes/delete-Shoe?id=${Shoe.id}">Delete</a>
    					<!--  &nbsp;<input type="file" name="image" accept="image/png, image/jpeg" />-->

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</form>
	<div class="form-popup" id="myForm">
		<form action="/sportyshoes/update-Shoe" class="form-container" method="post">
			<h2>Update Details</h2>

			<label><b>Shoes Id</b></label>
			<input type="text" placeholder="Shoes Id" name="getId" id="getId" value="">
			  
			 <label for="updatesize"><b>Update Size</b></label> 
			 <select id="updatesize" name="updatesize">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select> 
			 
			 <label for="updatecolor"><b>Update Color</b></label> 
			 <select id="updatecolor" name="updatecolor">
						<option value="Grey">Grey</option>
						<option value="Green">Green</option>
						<option value="Blue">Blue</option>
						<option value="Black">Black</option>
			</select>

			<label for="updategender"><b>Update Gender</b></label>
			 <select id="updategender" name="updategender">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
			</select> 
			 
			 <label for="updatebrand"><b>Update Brand</b></label>
			  <select id="updatebrand" name="updatebrand">
						<option value="Puma">Puma</option>
						<option value="sketcher">sketcher</option>
						<option value="Adidas">Adidas</option>
						<option value="Bata">Bata</option>
			   </select>
			   
			<label for="updatedate"><b>Update Date</b></label> 
			<input type="date"  name="updatedate">

			<input type="submit" class="btn" name="updatedetails" value="Update">
			<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
		</form>
	</div>
	<br>
	</form>
	<div class="form-popup" id="AddmyForm">
		<form action="/sportyshoes/AddShoes1" class="form-container" method="post">
			<h2>Enter Details</h2>

			<label for="addsize"><b>Enter Size</b></label> 
			<select id="addsize" name="addsize">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select>
				
			<label for="addcolor"><b>Enter Color</b></label> 
			<select id="addcolor" name="addcolor">
						<option value="Grey">Grey</option>
						<option value="Green">Green</option>
						<option value="Blue">Blue</option>
						<option value="Black">Black</option>
					</select>
			<label for="addgender"><b>Enter Gender</b></label> 
			<select id="addgender" name="addgender">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
			</select>
			
			
			<label for="addbrand"><b>Enter Brand</b></label> 
			<select id="addbrand" name="addbrand">
						<option value="Puma">Puma</option>
						<option value="sketcher">sketcher</option>
						<option value="Adidas">Adidas</option>
						<option value="Bata">Bata</option>
					</select>
			
			<label for="adddate"><b>Select Date</b></label> 
			<input type="date"  name="adddate">
			

			<input type="submit" class="btn" name="adddetails" value="Add">
			<button type="button" class="btn cancel" onclick="AddcloseForm()">Close</button>
		</form>
	</div>
	<div class="form-popup Report" id="ReportmyForm">
		<form action="/sportyshoes/PurchaseReport1" class="form-container" method="post">
			<h2>Select Date </h2>

			<label for="Reportdate"><b>Select Date</b></label> 
			<input type="date"  name="Reportdate">
			

			<input type="submit" class="btn" name="Reportdetails" value="proceed &raquo;">
			<button type="button" class="btn cancel" onclick="ReportcloseForm()">Close</button>
		</form>
	</div>

	<script>
	function AddopenForm() {
		document.getElementById("AddmyForm").style.display = "block";
	}

	function AddcloseForm() {
		document.getElementById("AddmyForm").style.display = "none";
	}
	function ReportopenForm() {
		document.getElementById("ReportmyForm").style.display = "block";
	}

	function ReportcloseForm() {
		document.getElementById("ReportmyForm").style.display = "none";
		
	}
	
		function openForm() {
			var SR_NO = document.getElementById("hiddenSr_No").value;
			document.getElementById("getId").value = SR_NO;
			document.getElementById("myForm").style.display = "block";
			
		}

		function closeForm() {
			document.getElementById("myForm").style.display = "none";
		}
		
	 /*	$('fgender').on('change', function() {
			
		var jGender = $( "#fgender option:selected" ).val();
		var jColor = $( "#fcolor option:selected" ).val();
		var jBrand = $( "#fbrand option:selected" ).val();
		var jIspurchased = $( "#fpurchased option:selected" ).val();
		var jdate = $( "#fdate option:selected" ).val();
		
		var str = "/sportyshoes/filterByAll?Gender="+jGender+"&Color="+jColor+"&Brand="+&jBrand+"&Ispurchased="+jIspurchased+"&Date="+jIspurchased;
		$('#filterdiv').val(str);
		
		});*/

	</script>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>