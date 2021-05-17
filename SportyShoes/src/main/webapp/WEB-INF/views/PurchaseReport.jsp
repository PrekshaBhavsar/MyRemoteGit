<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sold Shoes Information</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
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
 <a href="/sportyshoes/Home" class="dropdown-item">Logout</a>
 </div>
 <br><br><br>
<div class="container">
		<table class="table">
			<caption>Purchased items</caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>Size</th>
					<th>color</th>
					<th>Gender</th>
					<th>Brand</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${AllPurchasedShoes}" var="Shoe">
					<tr>
						<td>${Shoe.id}</td>
						<td>${Shoe.size}</td>
						<td>${Shoe.color}</td>
						<td>${Shoe.gender}</td>
						<td>${Shoe.brand}</td>
						<td>${Shoe.purchasedate}</td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<center>
	<a type="button" class="btn btn-primary" href="/sportyshoes/AllShoesData">Back</a>
	</center>

</body>
</html>