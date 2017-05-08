<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Movie</title>
        <link rel="stylesheet" type="text/css" href="formatting.css"/>
    </head>
    <body>
        <div class="wrap">
            
        <%@ include file="includes/header.jsp" %>
        <%@ include file="includes/menu.jsp" %>
       
        <div class="main">
            
        <h1>Add A New Customer</h1>
        <hr>
        
        <form name="addForm" action="addCustomer" method="post">
          <table>
            <tbody>
                <tr>
                 <td>First Name:</td>
                 <td><input type="text" name="firstName" value=""/></td><br>
                </tr>
                
                <tr>
                 <td>Last Name:</td>
                 <td><input type="text" name="lastName" value=""/></td><br>
                </tr>
            
                <tr>
                <td>Address 1:</td>
                <td><input type="text" name="addr1" value=""/></td><br>
                </tr>
                
                <tr>
                <td>Address 2:</td>
                <td><input type="text" name="addr2" value=""/></td><br>
                </tr>
                    
                <tr>
                  <td>City:</td>
                  <td><input type="text" name="city" value=""/></td><br>
                </tr>
                
                <tr>  
                 <td>State:</td>
                 <td><input type="text" name="stateName" value=""/></td><br>
                </tr>
            
                <tr>
                 <td>Zip:</td>
                 <td><input type="text" name="zip" value=""/></td><br>
                </tr>
                
                <tr>  
                 <td>Email Address:</td>
                 <td><input type="text" name="emailAddr" value=""/></td><br>
                </tr>
                
                <br>
            <input type="submit" name="submit" value="Submit">
            </tbody>
          </table>
        </form>
        </div>
        
        <%@ include file="includes/footer.jsp" %>
        
        </div>
    </body>
</html>
