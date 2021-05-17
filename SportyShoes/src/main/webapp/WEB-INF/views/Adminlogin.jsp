<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
</style>
</head>
<title>Login</title>
<body>
	<div class="bg-img">
		<form method="post" class="container">

			<h1>Login</h1>

			<label for="uname"><b>Username</b></label> <i class="fa fa-user icon"></i>
			<input type="text" placeholder="Username" name="uname" value="Admin"
				required> <label for="pass"><b>Password</b></label> <input
				type="password" placeholder="Password" name="pass" required>

			<input type="submit" class="btn" value="Login"> 
			<br>
			<Center>
				<font color="red"><b>${ErrorMessage}</b></font>
			</Center>
		</form>

	</div>

</body>
</html>
