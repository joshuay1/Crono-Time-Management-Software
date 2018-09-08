<%-- shopping Page  --%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="domain.Admin" %>
<%@ page import="domain.Book" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='../resources/bootstrap.min.css'/>
    <link rel='stylesheet' href='../style.css'/>
    <title>E-BookShop Order</title>
</head>
<body>
<h2>E-Bookshop</h2>
<hr /><br />

<p><strong>Choose a book :</strong></p>

<div class='container'>

    <table class='table table-bordered table-striped'>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th> </th>

        </tr>
        <%
            for (Book book : Book.getAllAvailableBooks()) {
        %>
        <tr>
            <form name="AddToCartForm" action="shop" method="post">
                <input type="hidden" name="bookID" value="<%= book.getIsbn()%>">
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td align="right">$<%= book.getPrice() %></td>
                <td align="left"> <input type="submit" value="Add to Shopping Cart"> </td>
            </form>
        </tr>
        <%
            } // for loop
        %>
    </table>
</div>

<div class='container'>

    <table class='table table-bordered table-striped'>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th> </th>

        </tr>
        <%
            for(int i= 0 ; i<Admin.getAllTimes(Admin.getUsers()).getIDs().size(); i++) {
        %>
        <tr>
            <form name="AddToCartForm" action="shop" method="post">
                <input type="hidden" name="timeSheetID" value="<%= Admin.getAllTimes(Admin.getUsers()).getIDs(i)%>">
                <td><%= Admin.getAllTimes(Admin.getUsers()).getFirstNames(i) %></td>
                <td><%= Admin.getAllTimes(Admin.getUsers()).getLastNames(i) %></td>
                <td><%=  Admin.getAllTimes(Admin.getUsers()).getStartTimes(i) %></td>
                <td><%=  Admin.getAllTimes(Admin.getUsers()).getFinishTimes(i) %></td>
                <td align="right"><%=  Admin.getAllTimes(Admin.getUsers()).getDates(i) %></td>
                <td align="left"> <input type="submit" value="something"> </td>
            </form>
        </tr>
        <%
            } // for loop
        %>
    </table>
</div>

<div class='container'>
    <a href="cart"> Shopping Cart</a>
</div>

</body>
</html>