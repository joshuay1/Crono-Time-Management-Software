package domain;

import java.sql.SQLException;

import datasource.UnitOfWork;
import datasource.UserMapper;

public class User {


    private String firstName;
    
    private String lastName;
    private String email;
    
    private String userName;
    private String password;
    


    public User( String firstName, String lastName, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        
    }

    public String getEmail() {
        return email;
    }

    public void updateEmail(String email) {
        this.email = email;
    }
    
    public String getUserName() {
        return email;
    }

    public void updateUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return userName;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
    
  

    public String getFirstName() {
        return firstName;
    }

    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }
    
//    public static int getID(String username,String password) throws SQLException {
//    	return UserMapper.checkLogin(username, password);
//    }

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
}
