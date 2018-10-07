package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.UserMapper;

public class Admin extends User {
	
	public Admin(int id, String firstName, String lastName, String email, String userName, String password, String role,int versionN) {
		super( firstName, lastName, email, userName, password,id,role,versionN);
		
	}
	
	
	public static List<Employee> getAllUsers() throws SQLException {
        
        return Roster.getEmployees();
	}
	
	

}
