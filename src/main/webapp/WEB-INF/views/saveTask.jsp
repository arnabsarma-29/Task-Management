<%@ page contentType = "text/html;charset = UTF-8" language = "java" %>
	<html>
	<head>
		<title>Add Task</title>
	</head>
	<body>
		<h1>Add Task</h1>
		<form action = "/saveTask" method = "post">
			Task:
			<input type = "text" name = "data" required />
			<br><br>
			Duration:
			<input type = "text" name = "duration" required />
			<br><br>
			<button type = "submit">Save</button>
		</form>
		<br>
		<form action = "/home" method = "get" style = "display:inline;">
			<button type = "submit">Home</button>
		</form>
		&nbsp;&nbsp;
		<form action = "/showTasks" method = "get" style = "display:inline;">
			<button type = "submit">View Tasks</button>
		</form>
	</body>
	</html>