<%@ page import="auth.AppSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Shop</title>
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
</head>
<body>
<h2>Book Shop</h2>

<% if (!AppSession.isAuthenticated()) {%>

<form action="login" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="Login">
</form>

<% } else {%>

You are already logged in as <%=AppSession.getUser().getFirstName()%>
<div class='container'>
    <a href="shop"> Go shopping </a>
</div>

<%} %>
</body>
</html>
