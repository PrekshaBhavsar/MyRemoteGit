<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<style>
body, html {body { height:100vh;
	width: 100%;
	min-height: 380px;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;
}

}
* {
	box-sizing: border-box;
}

/* Add styles to the form container */
.container {
	position: relative;
	left: 500px;
	top: 100px;
	margin: 20px;
	max-width: 300px;
	padding: 16px;
	background-color: none;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Set a style for the submit button */
.btn {
	background-color: #6495ED;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.btn:hover {
	opacity: 1;
}
a.btn.btn-primary.close{
	position:absolute;
	left:545px;
	top:550px;
	max-width: 265px;
	text-align: center;
}
</style>
<body>
<div class="bg-img">
		<form method="post" class="container">

			<h1>Change Password</h1>

			<label for="uname"><b>Admin</b></label>
			<input type="text" placeholder="Username" name="uname" value="Admin" required>
			
			 <label for="Currentpass"><b>Current Password</b></label> 
			 <input type="password" placeholder="Password" name="Currentpass" required>
			 
			 <label for="Newpass"><b>New Password</b></label> 
			 <input type="password" placeholder="Password" name="Newpass" required>

			<input type="submit" class="btn" value="Change password">
							
		</form>
		 <a class="btn btn-primary close" href="/sportyshoes/AllShoesData">Close</a>
		 <Center>
				<font color="red"><b>${ErrorMessage}</b></font>
		</Center>
		
	</div>

</body>
</html>