<%-- 
    Document   : index
    Created on : May 7, 2017, 5:33:35 PM
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
        <link rel="stylesheet" type="text/css" href="formatting.css"/>
    </head>
    <body>
        <div class="wrap">
            
        <%@ include file="includes/header.jsp" %>
        <%@ include file="includes/menu.jsp" %>
       
        <div class="main">
        <h2>Customers Database</h2>
        </div>
        
        <div class="main">
            
        <h3>Search Customers</h3>
        
        <form name="searchForm" action="search" method="post">
            
            <input type="text" name="searchVal" value="" />
            
            <br>
            
            <input type="submit" name="submit" value="Search" />
            
        </form>
        </div>
        
        <%@ include file="includes/footer.jsp" %>
        
        </div>
    </body>
</html>
