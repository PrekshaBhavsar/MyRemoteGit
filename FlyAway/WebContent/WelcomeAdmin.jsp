<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.welcome label{
	position : absolute;
	top : 5%;
	right : 150px;
	font-size: 18px;
	font-weight: bolder;
    color: white;
    text-decoration: underline;
}
</style>
</head>
<body>
	<div class ="welcome">
	<%--<% String uname = (String)request.getAttribute("Adminname");
	 out.println("Welcome, "+ uname); --%>
	<label>Welcome, Admin</label>
	</div>

</body>
</html>