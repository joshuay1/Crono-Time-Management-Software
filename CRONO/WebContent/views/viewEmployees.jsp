<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="auth.AppSession"%>
<%@ page import="domain.Admin"%>
<%@ page import="domain.Employee"%>
<%@ page import="domain.User"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Users</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

</head>
<body>



	<%
		List<Employee> users = Admin.getAllUsers();
	%>



	<div class='container'>
		<h1>
			Welcome
			<%=User.getUser(AppSession.getUser()).getFirstName()%></h1>
		<form action="/CRONO/logout" method="post">
			<input type="submit" value="Logout">
		</form>
		<h2>These are all the users</h2>

		<table class='table table-bordered table-striped'>
			<tr>
				<th>View</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Role</th>
			</tr>
			<%
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getRole().equals("Employee")) {
			%>
			<tr>
				<td>
					<form method="get" action="/CRONO/adminEdit">
						<input type="hidden" name="ID" value="<%=users.get(i).getID()%>"></input>
						<input type="submit" value="View">
					</form>
				</td>
				<td><%=users.get(i).getFirstName()%></td>
				<td><%=users.get(i).getLastName()%></td>
				<td><%=users.get(i).getEmail()%></td>
				<td><%=users.get(i).getRole()%>
			</tr>
			<%
				}
				}
			%>

		</table>
	</div>
	<h3>
		Create Profile:
		<button type="button" class="btn btn-primary" data-toggle="button"
			aria-pressed="false" autocomplete="off" id="btn1">Toggle</button>
	</h3>
	<div class="container" id="createProfile">
		<h1>Create New Profile</h1>
		<hr>
		<div class="row">
			<div class="col-md-9">

				<form method="POST" action="/CRONO/ViewEmployees"
					class="form-horizontal" role="form">
					<div class="form-group">
						<label class="col-lg-3 control-label">First name:</label>
						<div class="col-lg-8">
							<input class="form-control" name="firstName" type="text"
								placeholder="Bob">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Last name:</label>
						<div class="col-lg-8">
							<input class="form-control" name="lastName" type="text"
								placeholder="Smith">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Email:</label>
						<div class="col-lg-8">
							<input class="form-control" name="email" type="text"
								placeholder="BobSmith@email.com">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Username:</label>
						<div class="col-md-8">
							<input class="form-control" name="username" type="text"
								placeholder="Username123">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Password:</label>
						<div class="col-md-8">
							<input class="form-control" name="password1" type="password"
								placeholder="password123">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Confirm password:</label>
						<div class="col-md-8">
							<input class="form-control" name="password2" type="password"
								placeholder="password123">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Role:</label>
						<div class="col-md-8">
							<input class="form-control" name="Role" type="text"
								placeholder="'Admin' or 'Employee'" value="Employee">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-8">
							<input type="submit" class="btn btn-primary" value="Create">
							<span></span> <input type="reset" class="btn btn-default"
								value="Cancel">
						</div>
					</div>
				</form>
			</div>
		</div>
		<script>
			$("#createProfile").toggle();
			$(document).ready(function() {
				$("#btn1").click(function() {
					$("#createProfile").toggle();
				});
			});
		</script>
</body>
</html>