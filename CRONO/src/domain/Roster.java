package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.IdentityMap;
import datasource.KeyTable;
import datasource.UnitOfWork;
import datasource.UserMapper;

public class Roster {
	
	static List<User> users = new ArrayList<User>();
	
	public static List<User> getUsers() throws SQLException {
		users.clear();
        UserMapper.getAllUsers();
        ///add allemployees
        return users;
	}
	
	
	public static User getUser(int id)throws SQLException {
		User e = IdentityMap.getUser(id); 
		if(e == null) {
			e = UserMapper.getUser(id);
		}
		return e;
	}
	
	public static void addUser(int userID, String firstName,String lastName,String email,String username,String password, int role) {
		User e = new User( firstName, lastName, email, username,password, userID, role);
		IdentityMap.addUser(e);
		users.add(e);
		
	}
	
	public static void updateProfile(int userID, String firstName, String lastName, String email, String username, String password, int role) throws SQLException {
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
		
		
//		public static void createUser(String firstName, String lastName, String email, String username, String password, int role) {
//			KeyTable.getKey("userID");
//		}
		
	}
	
	
	

}
