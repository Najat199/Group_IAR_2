package EasyWayApplication;

import java.util.Date;

public class Person {

    private int ID;
    private String Fname;
    private String Lname;
    private String Email;
    private String Password;
    private int phoneNo;
    private Date birthDate;
    private String Address;

    public Person() {

    }

    public int getID() {
        return ID;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Person(int ID, String Fname, String Lname, String Email, String Password, int phoneNo, Date birthDate, String Address) {
        this.ID = ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Email = Email;
        this.Password = Password;
        this.phoneNo = phoneNo;
        this.birthDate = birthDate;
        this.Address = Address;
    }

    public void signUp() {
    }

    public void login() {
    }

}
