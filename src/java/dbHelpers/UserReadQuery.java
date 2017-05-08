/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

/**
 *
 * @author Jake
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;

public class UserReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public UserReadQuery() {
        
       Properties propa= new Properties();
       InputStream instr=getClass().getResourceAsStream("dbConn.properties");
        try {
            propa.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver= propa.getProperty("driver.name");
       String url= propa.getProperty("server.name");
       String username= propa.getProperty("user.name");
       String passwd= propa.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doRead(){
        
        try {
            String query= "SELECT * FROM Customers";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public String getHTMLuserTable(){
        
            String userTable="";
            userTable += "<table class='table table-striped table-bordered table-hover'>";
            userTable += "<thead>";
            userTable +="<tr>";
               
                userTable+="<th>";
                    userTable+="Customer ID";
                userTable+="</th>";
                
                userTable+="<th>";
                    userTable+="First Name";
                userTable+="</th>";
                
                userTable+="<th>";
                    userTable+="Last Name";
                userTable+="</th>";
                
                userTable+="<th>";
                    userTable+="Address 1";
                userTable+="</th>";
                
                userTable+="<th>";
                    userTable+="Address 2";
                userTable+="</th>";
                
                userTable+="<th>";
                    userTable+="City";
                userTable+="</th>";
                
                userTable+="<th>";
                    userTable+="State";
                userTable+="</th>";
                
                userTable+="<th>";
                userTable+="Zip Code";
                userTable+="</th>";
                
                userTable+="<th>";
                    userTable+="Email Address";
                userTable+="</th>";
                
                
               userTable +="</tr>";
               userTable += "</thead>";
               userTable += "<tbody>";
         try {   
            while(this.results.next()){
                
                Customers customer = new Customers();
                customer.setCustID(this.results.getInt("custID"));
                customer.setFirstName(this.results.getString("firstName"));
                customer.setLastName(this.results.getString("lastName"));
                customer.setAddr1(this.results.getString("addr1"));
                customer.setAddr2(this.results.getString("addr2"));
                customer.setCity(this.results.getString("city"));
                customer.setStateName(this.results.getString("stateName"));
                customer.setZip(this.results.getInt("zip"));
                customer.setEmailAddr(this.results.getString("emailAddr"));

                userTable += "<tr>";
                
                       
                    userTable += "<td>";
                        userTable += customer.getCustID();  
                    userTable +="</td>";
                    
                    userTable += "<td>";
                        userTable += customer.getFirstName();  
                    userTable +="</td>";
                    
                    userTable += "<td>";
                        userTable += customer.getLastName();  
                    userTable +="</td>";
                    
                    userTable += "<td>";
                        userTable += customer.getAddr1();  
                    userTable +="</td>";
                    
                    userTable += "<td>";
                        userTable += customer.getAddr2();  
                    userTable +="</td>";
                    
                    userTable += "<td>";
                        userTable += customer.getCity();  
                    userTable +="</td>";
                    
                    userTable += "<td>";
                        userTable += customer.getStateName();  
                    userTable +="</td>";
                    
                    userTable += "<td>";
                        userTable += customer.getZip();  
                    userTable +="</td>";
                    
                    userTable += "<td>";
                        userTable += customer.getEmailAddr();  
                    userTable +="</td>";
                              
                
                userTable +="</tr>";
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        userTable += "</tbody>";
        userTable +="</table>";
        return userTable;
        
    }
}
