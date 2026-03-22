<%@ page contentType = "text/html;charset = UTF-8" language = "java" %>
	<html>
	<head>
		<title>Welcome</title>
	</head>
	<body>
		<h1>Welcome to Task Management App</h1>
		<p>Please choose an option:</p>
		<form action = "/login" method = "get" style = "display: inline">
			<button type = "submit">Login</button>
		</form>
		&nbsp;&nbsp;
		<form action = "/register" method = "get" style = "display: inline">
			<button type = "submit">Register</button>
		</form>
	</body>
	</html>