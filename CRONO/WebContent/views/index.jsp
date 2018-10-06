<%@ page import="sesh.Session" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CRONO</title>
    <link rel='stylesheet' href='resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='style.css'/>
</head>
<body>
<h2>Home: CRONO</h2>
<% 	/* Cookie cook=new Cookie("username","admin");
	response.addCookie(cook);
	Cookie ck[]=request.getCookies();
    String username = ck[0].getValue(); */
    Session wrappedSession = Session.refreshSession(session,"admin");
    if (session.isNew()) {%>

Hello new user! We hope you'll like it here :)

<% } else {%>


Welcome back, <%=wrappedSession.getUser("admin").getFirstName()%>

<%} %>
<div class='container'>
	<form method="get" action ="/CRONO/home">
	<input type="hidden"  name = "ID" value = "<%=wrappedSession.getUser("admin").getID()%>">
    <input type="submit" value="Login">
	</form>
</div>

</body>
</html> 