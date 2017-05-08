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

public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery() {
        
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
    
    public String getHTMLtable(){
        
            String table="";
            table += "<table class='table table-striped table-bordered table-hover'>";
            table += "<thead>";
            table +="<tr>";
               
                table+="<th>";
                    table+="Customer ID";
                table+="</th>";
                
                table+="<th>";
                    table+="First Name";
                table+="</th>";
                
                table+="<th>";
                    table+="Last Name";
                table+="</th>";
                
                table+="<th>";
                    table+="Address 1";
                table+="</th>";
                
                table+="<th>";
                    table+="Address 2";
                table+="</th>";
                
                table+="<th>";
                    table+="City";
                table+="</th>";
                
                table+="<th>";
                    table+="State";
                table+="</th>";
                
                table+="<th>";
                table+="Zip Code";
                table+="</th>";
                
                table+="<th>";
                    table+="Email Address";
                table+="</th>";
                
                
               table +="</tr>";
               table += "</thead>";
               table += "<tbody>";
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

                table += "<tr>";
                
                       
                    table += "<td>";
                        table += customer.getCustID();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += customer.getFirstName();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += customer.getLastName();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += customer.getAddr1();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += customer.getAddr2();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += customer.getCity();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += customer.getStateName();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += customer.getZip();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += customer.getEmailAddr();  
                    table +="</td>";
                              
                
                table +="</tr>";
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table += "</tbody>";
        table +="</table>";
        return table;
        
    }
}
