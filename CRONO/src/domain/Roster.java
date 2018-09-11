package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.IdentityMap;
import datasource.UnitOfWork;
import datasource.UserMapper;

public class Roster {
	
	static List<Employee> employees = new ArrayList<Employee>();
	
//	public static List<Employee> getUsers() throws SQLException {
//        UserMapper.getAllEmployees();
//        ///add allemployees
//        return employees;
//	}
	
	
	public static Employee getEmployee(int id)throws SQLException {
		Employee e = IdentityMap.getEmployee(id); 
		if(e == null) {
			e = UserMapper.getEmployee(id);
		}
		return e;
	}
	
	public static void addEmployee(int userID, String firstName,String lastName,String email,String username,String password) {
		Employee e = new Employee(userID, firstName, lastName, email, username, password);
		IdentityMap.addEmployee(e);
		
	}
	
	public static void updateProfile(int userID, String firstName, String lastName, String email, String username, String password) throws SQLException {
		Employee e = Roster.getEmployee(userID);
		e.updateUserName(username);
		e.updateEmail(email);
		e.updatePassword(password);
		e.updateFirstName(firstName);
		e.updateLastName(lastName);
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirtyUser(e);
		UnitOfWork.getCurrent().commit();
	}
	
	
	

}
