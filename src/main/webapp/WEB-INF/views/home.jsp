<%@ page contentType = "text/html;charset = UTF-8" language = "java" %>
	<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>Welcome to Home Page</h1>
		<br>
		<form action = "/saveTask" method = "get" style = "display:inline;">
			<button type = "submit">Add Task</button>
		</form>
		&nbsp;&nbsp;
		<form action = "/showTasks" method = "get" style = "display:inline;">
			<button type = "submit">View Tasks</button>
		</form>
		&nbsp;&nbsp;
		<form action = "/settings" method = "get" style = "display:inline;">
			<button type = "submit">Settings</button>
		</form>
		&nbsp;&nbsp;
		<form action = "/logout" method = "get" style = "display:inline;">
			<button type = "submit">Logout</button>
		</form>
	</body>
	</html>