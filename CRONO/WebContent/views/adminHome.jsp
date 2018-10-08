<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="auth.AppSession" %>
<%@ page import="domain.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Portal</title>
<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'/>
<link rel='stylesheet' href='style.css'/>
</head>
<body>
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
	        <a class="nav-link" href="/CRONO/ViewEmployees">Check Employees</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/CRONO/logout">Log Out</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	
	<div class='container'>
		<h1>Welcome  <%=User.getUser(AppSession.getUser()).getFirstName()%></h1>
		<h2>To your HomePage</h2>
	</div>



</body>
</html>