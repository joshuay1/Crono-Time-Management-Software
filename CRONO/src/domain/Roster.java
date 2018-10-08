package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.IdentityMap;
import datasource.KeyTable;
import datasource.UnitOfWork;
import datasource.UserMapper;

public class Roster {
	
	static List<Admin> admins = new ArrayList<Admin>();
	static List<Employee> employees = new ArrayList<Employee>();
	
	public static List<Employee> getEmployees() throws SQLException {
		employees.clear();
        UserMapper.getAllUsers();
        ///add allemployees
        return employees;
	}
	
	
	public static User getUser(int id)throws SQLException {
		User e = IdentityMap.getAdmin(id); 
		if(e == null) {
			e = IdentityMap.getEmployee(id);
		}
		if(e == null) {
			e = UserMapper.getUser(id);
		}
		return e;
	}
	public static Employee getEmployee(int id)throws SQLException {
		User u = UserMapper.getUser(id);
		Employee e = new Employee(u.getID(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getUserName(), u.getPassword(), u.getRole(),u.getVersionN());
		return e;
		
	}
	
	public static void addUsers(int userID, String firstName,String lastName,String email,String username,String password, String role,int version) {
		
		if(role.equals("Admin")) {
			Admin e = new Admin(userID, firstName, lastName, email, username,password, role,version);
			IdentityMap.addAdmin(e);
			admins.add(e);
		}
		else if(role.equals("Employee") ) {
			Employee e = new Employee(userID, firstName, lastName, email, username,password, role,version);
			IdentityMap.addEmployee(e);
			employees.add(e);
		}
		else {
			System.out.println("User is neither");
		}
			
		
		
	}
	
	
	
	public static void updateProfile(int userID, String firstName, String lastName, String email, String username, String password) throws SQLException {
		User e = Roster.getUser(userID);
		e.updateUserName(username);
		e.updateEmail(email);
		e.updatePassword(password);
		e.updateFirstName(firstName);
		e.updateLastName(lastName);
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirtyUser(e);
		UnitOfWork.getCurrent().commit();
	}
	
	public static void deleteUser(int userID) {
		User e = null;
		try {
			e = Roster.getUser(userID);
		} catch (SQLException b) {
			// TODO Auto-generated catch block
			b.printStackTrace();
		}
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleteUser(e);
		try {
			UnitOfWork.getCurrent().commit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
		
	public static void createUser(String firstName, String lastName, String email, String username, String password, String role) throws SQLException {

			int key =KeyTable.getKey("userID");


			UserMapper.create(key, firstName, lastName, email, username, password, role,1);
			if(role == "Employee") {
				Employee e = new Employee(key, firstName, lastName, email, username, password, role,1);
				IdentityMap.addEmployee(e);
				
			}
			if(role == "Admin") {
				Admin e = new Admin(key, firstName, lastName, email, username, password, role,1);
				IdentityMap.addAdmin(e);
				
			}

	}
		
	
	
	

}
