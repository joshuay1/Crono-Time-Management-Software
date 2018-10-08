package domain;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import datasource.IdentityMap;
import datasource.KeyTable;
import datasource.TimeMapper;
import datasource.UnitOfWork;
import datasource.UserMapper;

public class User {


    private String firstName;
    
    private String lastName;
    private String email;
    
    private String userName;
    private String password;
    
    protected int id;
    private String role;
    private int pay;
    private int versionN;


    public User( String firstName, String lastName, String email, String userName, String password,int id, String role,int versionN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.role = role;
        this.versionN = versionN;
        
        
    }
    
    public int getVersionN() {
		return versionN;
	}

	public void setVersionN(int versionN) {
		this.versionN = versionN;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
    
    public static User getUser(int userId) throws SQLException {
        return UserMapper.getUser(userId);
    }

    public static User getUser(String username) throws SQLException {
        return UserMapper.getUser(username);
    }
    
    
    public Set<String> getUserPermission(String role) {
        return UserMapper.getUserPermission(role);
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
    
    public List<Time> getTimeSheet() throws SQLException {
        return TimeMapper.findMyTime(id);
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
