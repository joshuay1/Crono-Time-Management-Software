<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="sesh.Session" %>
    <%@ page import= "domain.Employee" %>
     <%@ page import= "domain.User" %>
    <%@ page import= "domain.Roster" %>
    <%@ page import= "domain.Time" %>
    <%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<% 
		int employeeID = Integer.parseInt(request.getParameter("ID"));
		User e = null;
		e =  Roster.getUser(employeeID);
    	List<Time> times = null;
		times = e.getTimeSheet();
		%>
		<h1>Viewing <%=e.getFirstName() %>'s Profile
		<div class='container'>
			<form method="post" action ="/CRONO/adminEdit">
				<input type="hidden"  name = "type" value = 1>
				<input type="hidden"  name = "ID" value = "<%=employeeID%>">
   				<input type="submit" value="Delete Users">
			</form>
		</div>
		</h1>
		<div>
		 <h3>View Timetable:<button type="button" class="btn btn-primary" data-toggle="button" aria-pressed="false" autocomplete="off" id = "btn1"> Toggle</button></h3>
		<div class='container' id = "TimeTableView">
		<h1>This is:  <%=e.getFirstName()%> TimeSheet</h1>
			<table class='table table-bordered table-striped'>
			<tr><th>StartTime</th><th>FinishTime</th><th>Date</th><th>Payment for work (will convert for feature 2)</th><th>Paid</th></tr>
			<% for(int i= 0 ; i<times.size(); i++) { %>
				<tr><td> <%=times.get(i).getStartTime()  %></td><td><%=times.get(i).getFinishTime()  %></td><td><%=times.get(i).getDate()  %></td><td><%=times.get(i).getPay()  %></td><td><%if(times.get(i).getPaid() == 0){%>
																																											
																																															<form method="post" action ="/CRONO/adminEdit">
																																																<input type="hidden"  name = "type" value = 2>
																																																<input type="hidden"  name = "ID" value = "<%=times.get(i).getTimeID() %>">
																																																<input type="hidden"  name = "userID" value = "<%=employeeID %>">
																																												   				<input type="submit" value="Pay">
																																															</form>
																																														<% } else {%> Paid<% }%></td></tr>
			<% } %>

    	</table>
   		</div>
   		</div>
   	
	<h3>View/Edit Profile:<button type="button" class="btn btn-primary" data-toggle="button" aria-pressed="false" autocomplete="off" id = "btn2"> Toggle</button></h3>   	
	<div class="container" id = "profileEdit">
    <h1>Edit <%=e.getFirstName()%> Profile </h1>
    <p>Current: <br><strong>First Name:</strong> <%=e.getFirstName() %>,</br> <br><strong>last name:</strong> <%=e.getLastName() %>,</br> <br><strong> Email:</strong> <%=e.getEmail() %>,</br> <br><strong> Username:</strong> <%=e.getUserName() %></br></p>
  	<hr>
	<div class="row">
      <div class="col-md-9">
        
        <form method = "POST" action ="/CRONO/adminEdit" class="form-horizontal" role="form">
        <input type = "hidden" name = "ID" value = "<%=e.getID()%>"></input>
         <input type = "hidden" name = "Role" value = "<%=e.getRole()%>"></input>
         <input type = "hidden" name = "Password1" value = "<%=e.getPassword()%>"></input>
         <input type = "hidden" name = "Password2" value = "<%=e.getPassword()%>"></input>
         <input type="hidden"  name = "type" value = 3>
         
          <div class="form-group">
            <label class="col-lg-3 control-label">First name:</label>
            <div class="col-lg-8">
              <input class="form-control" name="firstName" type="text" placeholder="Bob">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Last name:</label>
            <div class="col-lg-8">
              <input class="form-control" name="lastName" type="text" placeholder="Smith">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Email:</label>
            <div class="col-lg-8">
              <input class="form-control" name = "email" type="text" placeholder="BobSmith@email.com">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Username:</label>
            <div class="col-md-8">
              <input class="form-control" name="username" type="text" placeholder="Username123">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <input type="submit" class="btn btn-primary" value="Save Changes">
              <span></span>
              <input type="reset" class="btn btn-default" value="Cancel">
            </div>
          </div>
        </form>
      </div>
  </div>
</div>

<script>
$("#TimeTableView").toggle();
$("#profileEdit").toggle();
$(document).ready(function(){
    $("#btn1").click(function(){
        $("#TimeTableView").toggle();
    });
});
$("#btn2").click(function(){
    $("#profileEdit").toggle();
});
</script>

<form action="/CRONO/logout" method="post">
    <input type="submit" value="Logout">
</form>

</body>
</html>