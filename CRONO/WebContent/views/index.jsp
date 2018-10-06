<%@ page import="sesh.Session" %>
<%@ page import = "domain.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CRONO</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel='stylesheet' href='style.css'/>
</head>
<body>
<h2>Home: CRONO</h2>

<% 	/* Cookie cook=new Cookie("username","admin");
	response.addCookie(cook);
	Cookie ck[]=request.getCookies();
    String username = ck[0].getValue(); */
    Session wrappedSession = Session.refreshSession(session,"admin");
    User u = wrappedSession.getUser("admin");
    if (session.isNew()) {%>

Hello new user! We hope you'll like it here :)

<% } else {%>


Welcome back, <%=u.getFirstName()%>

<%} %>
<div class='container'>
	<form method="post" action ="/CRONO/home">
	<%-- <input type="hidden"  name = "Role" value = "<%=u.getRole()%>"> --%>
	<input type="text"  name = "Role" placeholder = "enter role: admin = 0, employee = 1">
    <input type="submit" value="Login">
	</form>
</div>

</body>
</html> 