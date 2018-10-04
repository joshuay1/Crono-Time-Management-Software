
<%@ page contentType="text/html;charset=UTF-8" %>
 <%@ page import="sesh.Session" %>
 <% Session wrappedSession = Session.refreshSession(session,"admin"); %>


<html>
<head>
  
    <title> Edit: <%=wrappedSession.getUser("admin").getFirstName()%></title>
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
	        <a class="nav-link" href="/CRONO/views/home">Home <span class="sr-only">(current)</span></a>
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
    <h1>Edit Profile</h1>
  	<hr>
	<div class="row">
      <div class="col-md-9">
        
        <form method = "POST" action ="editProfile" class="form-horizontal" role="form">
        <input type = "hidden" name = "ID" value = "<%=wrappedSession.getUser("admin").getID()%>"></input>
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
            <label class="col-md-3 control-label">Password:</label>
            <div class="col-md-8">
              <input class="form-control" name = "password1" type="password" placeholder="password123">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Confirm password:</label>
            <div class="col-md-8">
              <input class="form-control" name = "password2" type="password" placeholder="password123">
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
<hr>



</body>
</html>