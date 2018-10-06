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
<title>Employee Times</title>
<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'/>
<link rel='stylesheet' href='style.css'/>
</head>
<body>
	<% 
		Session wrappedSession = Session.refreshSession(session,"user1"); 
		Employee e = null;
		e = Roster.getEmployee(wrappedSession.getUser("user1").getID());
    	List<Time> times = null;
		times = e.getTimeSheet();
		%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">CRONO</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="/CRONO/home">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/CRONO/createTime">Clock in</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/CRONO/times">View Time</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link disabled"  href="/CRONO/editProfile">Edit Profile</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	
	<div class='container'>
		<h1>Welcome  <%=wrappedSession.getUser("user1").getFirstName()%></h1>
		<h2>To your TimeSheet</h2>
		<%-- <p>You have <% e.getNumberTimes();%><p> --%>
		
	<table class='table table-bordered table-striped'>
	<tr><th>StartTime</th><th>FinishTime</th><th>Date</th><th>Payment for work (will convert for feature 2)</th><th>Paid</th></tr>
	<% for(int i= 0 ; i<times.size(); i++) { %>
		<tr><td> <%=times.get(i).getStartTime()  %></td><td><%=times.get(i).getFinishTime()  %></td><td><%=times.get(i).getDate()  %></td><td><%=times.get(i).getPay()  %></td>
		<td><%if(times.get(i).getPaid() == 0){%>NO<%}else if(times.get(i).getPaid() == 1){%>YES!<% } %></td></tr>
	<% } %>

    	</table>
   	</div>
    		

</body>
</html>