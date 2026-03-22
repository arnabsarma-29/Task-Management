<%@ page contentType = "text/html;charset = UTF-8" language = "java" %>
	<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<h1>Login Page</h1>
		<p style = "color:green;">
			${message}
		</p>
		<p style = "color:red;">
			${passwordMessage}
		</p>
		<form action = "/login" method = "post">
			Username: <input type = "text" name = "username" /><br><br>
			Password: <input type = "password" name = "password" /><br><br>
			<button type = "submit">Login</button>
		</form>
	</body>
	</html>