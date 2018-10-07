<%@ page import="auth.AppSession" %>
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
    
    
//    Session wrappedSession = Session.refreshSession(session,"admin");
//    User u = wrappedSession.getUser("admin");
// <%=AppSession.getUser().getFirstName()
//    if (session.isNew()) {
%>


<%if (!AppSession.isAuthenticated()) {%>
Login here


<form action="/CRONO/home" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="Login">
</form>

<% } else {%>
Welcome back

<form action="/CRONO/logout" method="post">
    <input type="submit" value="Logout">
</form>

<%} %>
</body>

</html>
