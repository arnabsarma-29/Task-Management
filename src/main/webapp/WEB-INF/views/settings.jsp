<%@ page contentType = "text/html;charset = UTF-8" language = "java" %>
	<html>
	<head>
		<title>Settings</title>
	</head>
	<body>
		<h1>Settings</h1>
		<p>
			${message}
		</p>
		<hr>
		<h3>Update Username</h3>
		<form action = "/settings/updateUsername" method = "post">
			New Username:
			<input type = "text" name = "username" required />
			<br><br>
			<button type = "submit">Update Username</button>
		</form>
		<hr>
		<h3>Update Email</h3>
		<form action = "/settings/updateEmail" method = "post">
			New Email:
			<input type = "email" name = "email" required />
			<br><br>
			<button type = "submit">Update Email</button>
		</form>
		<hr>
		<h3>Update Password</h3>
		<form action = "/settings/updatePassword" method = "post">
			Old Password:
			<input type = "password" name = "oldPassword" required />
			<br><br>
			New Password:
			<input type = "password" name = "newPassword" required />
			<br><br>
			<button type = "submit">Update Password</button>
		</form>
		<hr>
		<form action = "/home" method = "get" style = "display:inline;">
			<button type = "submit">Home</button>
		</form>
		&nbsp;&nbsp;
		<form action = "/logout" method = "get" style = "display:inline;">
			<button type = "submit">Logout</button>
		</form>
	</body>
	</html>