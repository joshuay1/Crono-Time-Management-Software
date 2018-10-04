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
    
    protected int id;
    


    public User( String firstName, String lastName, String email, String userName, String password,int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.id = id;
        
        
    }
    
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void updateEmail(String email) {
        this.email = email;
    }
    
    public String getUserName() {
        return userName;
    }

    public void updateUserName(String userName) {
        this.userName = userName;
    }
    
    
    public static Employee getUser(String username) throws SQLException {
        int id = UserMapper.getUserID(username);
        Employee result = Roster.getEmployee(id);
        return result;
    }
    
    
    
    
    public String getPassword() {
        return password;
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
