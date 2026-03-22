<%@ page contentType = "text/html;charset = UTF-8" language = "java" %>
	<html>
	<head>
		<title>Register</title>
	</head>
	<body>
		<h1>User Registration</h1>
		<form action = "/register" method = "post">
			Username:
			<input type = "text" name = "username" required />
			<br><br>
			Email:
			<input type = "email" name = "email" required />
			<br><br>
			Password:
			<input type = "password" name = "password" required />
			<br><br>
			<button type = "submit">Register</button>
		</form>
		<br>
		<a href = "/login">Already have an account? Login</a>
	</body>
	</html>