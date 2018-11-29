
<%@ page contentType="text/html;charset=UTF-8" %>
 <%@ page import="auth.AppSession" %>
  <%@ page import="domain.User" %>
  
  <% User u = User.getUser(AppSession.getUser()); %>


<html>
<head>
  
    <title> Edit: <%=u.getFirstName()%></title>
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
	        <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/createTime">Clock in</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/times">View Time</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link disabled"  href="/editProfile">Edit Profile</a>
	      </li>
	    </ul>
	  </div>
	</nav>



<div class="container">
    <h1>Edit Profile</h1>
  	<hr>
	<div class="row">
      <div class="col-md-9">
        
        <form method = "POST" action ="/editProfile" class="form-horizontal" role="form">
        <input type = "hidden" name = "ID" value = "<%=u.getID()%>"></input>
        <input type = "hidden" name = "Role" value = "<%=u.getRole()%>"></input>
        <input type = "hidden" name = "username" value = "<%=u.getUserName()%>"></input>
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

<form action="/logout" method="post">
    <input type="submit" value="Logout">
</form>

</body>
</html>