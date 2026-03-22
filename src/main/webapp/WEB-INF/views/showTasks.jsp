<%@ page contentType = "text/html;charset = UTF-8" language = "java" %>
	<%@ page import = "java.util.List" %>
		<%@ page import = "com.project1.task_management_app.dto.TaskDTO" %>
			<html>
			<head>
				<title>Show Tasks</title>
			</head>
			<body>
				<h1>Your Tasks</h1>
				<p>${message}</p>
				<hr>
				<table border="1">
					<tr>
						<th>ID</th>
						<th>Data</th>
						<th>Duration</th>
						<th>Update Data</th>
						<th>Update Duration</th>
					</tr>
					<% List<TaskDTO> tasks = (List<TaskDTO>) request.getAttribute("tasks");
							if (tasks != null && !tasks.isEmpty ())
							{
								for (TaskDTO task : tasks)
								{
								%>
								<tr>
									<td>
										<%= task.getId() %>
									</td>
									<td>
										<%= task.getData() %>
									</td>
									<td>
										<%= task.getDuration() %>
									</td>
									<td>
										<form action = "/updateData" method = "post">

											<input type = "hidden" name = "taskId"
												value = "<%= task.getId () %>" />

											<input type = "text" name = "data"
												placeholder = "New Data"
												required />
											<button type = "submit">Update</button>
										</form>
									</td>
									<td>
										<form action = "/updateDuration" method = "post">
											<input type = "hidden" name = "taskId"
												value = "<%= task.getId () %>" />
											<input type = "text" name = "duration"
												placeholder = "New Duration"
												required />
											<button type="submit">Update</button>
										</form>
									</td>
								</tr>
								<% } }
								else
								{ %>
									<tr>
										<td colspan="5">No tasks found</td>
									</tr>
								<% } %>
				</table>
				<br>
				<form action = "/saveTask" method = "get" style = "display:inline;">
					<button type = "submit">Add Task</button>
				</form>
				&nbsp;&nbsp;
				<form action = "/home" method = "get" style = "display:inline;">
					<button type = "submit">Home</button>
				</form>
				&nbsp;&nbsp;
				<form action = "/logout" method = "get" style = "display:inline;">
					<button type = "submit">Logout</button>
				</form>
			</body>
			</html>