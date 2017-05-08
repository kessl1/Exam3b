/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;

/**
 *
 * @author Jake
 */
public class AddQuery {
    private Connection conn;
    
    public AddQuery(){
         Properties propa= new Properties();
       InputStream instr=getClass().getResourceAsStream("dbConn.properties");
        try {
            propa.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver= propa.getProperty("driver.name");
       String url= propa.getProperty("server.name");
       String username= propa.getProperty("user.name");
       String passwd= propa.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doAdd(Customers customer){
            try {
            String query = "INSERT INTO customers (firstName, lastName, addr1, addr2, city, stateName, zip, emailAddr) VALUES (?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getAddr1());
            ps.setString(4, customer.getAddr2());
            ps.setString(5, customer.getCity());
            ps.setString(6, customer.getStateName());
            ps.setInt(7, customer.getZip());
            ps.setString(8, customer.getEmailAddr());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
