
package model;

/**
 *
 * @author Jake
 */
public class Customers {
    private int custID;
    private String firstName;
    private String lastName;
    private String addr1;
    private String addr2;
    private String city;
    private String stateName;
    private int zip;
    private String emailAddr;

    public Customers() {
        this.custID = 0;
        this.firstName = "";
        this.lastName = "";
        this.addr1 = "";
        this.addr2 = "";
        this.city = "";
        this.stateName = "";
        this.zip = 0;
        this.emailAddr = "";

    }
    
     public Customers(int custID, String firstName, String lastName, String addr1, String addr2, String city, String stateName, int zip, String emailAddr) {
        this.custID = custID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.city = city;
        this.stateName = stateName;
        this.zip = zip;
        this.emailAddr = emailAddr;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }
    
        public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }
    
    @Override
    public String toString() {
        return "Customers{" + "custID=" + custID + ", firstName=" + firstName + ", lastName=" + lastName + ", addr1=" + addr1 + ", addr2=" + addr2 + ", city=" + city + ", stateName=" + stateName + ", zip=" + zip + ", emailAddr=" + emailAddr +'}';
    }
       
}
