
<%@ page contentType="text/html;charset=UTF-8" %>
 <%@ page import="auth.AppSession" %>
 <%@ page import="domain.User" %>


<html>
<head>
  
    <title> Create Time: <%=User.getUser(AppSession.getUser()).getFirstName()%></title>
    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'/>
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
	        <a class="nav-link" href="/CRONO/views/home.jsp">Home <span class="sr-only">(current)</span></a>
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

<div class="container">
    <h1>Add Time</h1>
  	<hr>
	<div class="row">
      <div class="col-md-9">
        
        <form method = "POST" action ="/CRONO/createTime" class="form-horizontal" role="form">
        <input type = "hidden" name = "ID" value = "<%=User.getUser(AppSession.getUser()).getID()%>"></input>
          <div class="form-group">
            <label class="col-lg-3 control-label">Start Time:</label>
            <div class="col-lg-8">
              <input class="form-control" name="startTime1" type="text" placeholder="HH:MM">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Finish Time:</label>
            <div class="col-lg-8">
              <input class="form-control" name="finishTime1" type="text" placeholder="HH:MM">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Date:</label>
            <div class="col-lg-8">
              <input class="form-control" name = "date1" type="date" placeholder="DD/MM/YYYY">
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

<form action="/CRONO/logout" method="post">
    <input type="submit" value="Logout">
</form>

<hr>
