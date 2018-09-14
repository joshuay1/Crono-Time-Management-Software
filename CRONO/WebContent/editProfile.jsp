<%-- shopping Page  --%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="domain.Roster" %>


<html>
<head>
  
    <title> Edit: <% Roster.getEmployee(Integer.parseInt(request.getParameter("ID"))); %></title>
    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'/>
</head>
<body>
<h2>Edit Profile</h2>
<hr /><br />


<div class='container'>

    <table class='table table-bordered table-striped'>
		<form method="post" action ="editProfile">
			Actual User ID: <input type="number" placeholder="00x" name = "ID">
			Wanted First Name:<input type="text" placeholder ="John" name="firstName">
			Wanted Last Name:<input type="text" placeholder ="Smith" name="lastName">
    		New email: <input type="email" placeholder="user@example.com" name = "email">
    		New username: <input type="text" placeholder ="FunkyMuffin12" name="username">
    		New Password: <input type="password" name = "password123!" placeholder = "password">
   			<input type="submit" value="Submit">
		</form> 

    </table>
</div>


</body>
</html>