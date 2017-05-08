<%-- 
    Document   : read
    Created on : May 7, 2017, 6:42:19 PM
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Read</title>
        <link rel="stylesheet" type="text/css" href="formatting.css"/>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <div class="wrap">
            
        <%@ include file="includes/header.jsp" %>
        <%@ include file="includes/menu.jsp" %>
       
        <div class="main">
            
        <h1>Customers</h1>
        <hr>
        <a href ="add">Add a New Customer</a>
        <br><br>
        <%= table %>
        </div>
        
        <div class="main">
            
        <h3>Search Customers</h3>
        
        <form name="searchForm" action="search" method="post">
            
            <input type="text" name="searchVal" value="" />
            
            <br>
            
            <input type="submit" name="submit" value="Search" />
            
        </form>
        </div>
        <br>
        <a href="index.jsp">Log Out</a>
        <%@ include file="includes/footer.jsp" %>
        
        </div>
        
    </body>
</html>
