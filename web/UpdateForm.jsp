<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customers"%>
<% Customers customer = (Customers) request.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Customer</title>
        <link rel="stylesheet" type="text/css" href="formatting.css"/>
    </head>
    <body>
        <div class="wrap">
            
        <%@ include file="includes/header.jsp" %>
        <%@ include file="includes/menu.jsp" %>
       
        <div class="main">
        <h1>Update A Customer Record</h1>
        <hr>
        <form name="updateForm" action="updateCustomer" method="post">
          <table class="update">
            <tbody>
                <tr>
                 <td>Customer ID:</td>
                 <td><input type="text" name="custID" value="<%= customer.getCustID() %>" readonly/></td><br>
                </tr>
                
                <tr>
                 <td>First Name:</td>
                 <td><input type="text" name="firstName" value="<%= customer.getFirstName() %>" required/></td><br>
                </tr>
            
                <tr>
                <td>Last Name:</td>
                <td><input type="text" name="lastName" value="<%= customer.getLastName() %>"required/></td><br>
                </tr>
                    
                <tr>
                  <td>Address 1:</td>
                  <td><input type="text" name="addr1" value="<%= customer.getAddr1() %>" required/></td><br>
                </tr>
                
                <tr>  
                 <td>Address 2:</td>
                 <td><input type="text" name="addr2" value="<%= customer.getAddr2() %>"/></td><br>
                </tr>
            
                <tr>
                <td>City:</td>
                <td><input type="text" name="city" value="<%= customer.getCity() %>" required/></td><br>
                </tr>
                
                <tr>  
                 <td>State:</td>
                 <td><input type="text" name="stateName" value="<%= customer.getStateName()%>"maxlength="2" required/></td><br>
                </tr>
                
                <tr>  
                 <td>Zip Code:</td>
                 <td><input type="text" name="zip" value="<%= customer.getZip()%>"max="99999" min="10000" required/></td><br>
                </tr>
                
                <tr>  
                 <td>Email Address:</td>
                 <td><input type="text" name="emailAddr" value="<%= customer.getEmailAddr()%>" required/></td><br>
                </tr>
                
                <br>
            <input type="submit" name="submit" value="Update">
            <input type="reset" value="Clear" name="reset">
            </tbody>
          </table>
        </form>
        </div>
        
        <%@ include file="includes/footer.jsp" %>
        
        </div>
    </body>
</html>
