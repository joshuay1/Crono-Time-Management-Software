package datasource;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Employee;
import domain.Roster;

public class UserMapper {
	private final static String findStatementString =
	         "SELECT * " +
	         "  from APP.employees "+
	         "  WHERE userID = !0!";
	
	 private static final String findAllTimesStatement =
	         "SELECT * from APP.employees";
	
	public static void getAllEmployees() throws SQLException {
			PreparedStatement sqlPrepared = DBConnection.prepare(findAllTimesStatement);
			ResultSet rs = sqlPrepared.executeQuery();
			List<Employee> result = new ArrayList<Employee>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				Roster.addEmployee(id, firstName, lastName, email, username, password);
			}

	}
	
	
	public static Employee getEmployee(int id) throws SQLException {
			String str = stringSplit(findStatementString, ""+id, 0);
			PreparedStatement sqlPrepared = DBConnection.prepare(str);
			ResultSet rs = sqlPrepared.executeQuery();
			rs.next();
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);
			String userName = rs.getString(5);
			String password = rs.getString(6);
			Employee employee =new Employee(id, firstName, lastName, email, userName, password);
			return employee;
	}
	
	
	
	public static int getUserID(String userName) {
		String sql = "Select * "
				+ "From App.Employees "
				+ "WHERE username = '"+userName+"'";
		PreparedStatement sqlPrepared;
		try {
			sqlPrepared = DBConnection.prepare(sql);
			ResultSet rs = sqlPrepared.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("Errror with SQL");
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	
	
	public static void update(int userID, String firstName, String lastName, String email, String username, String password) throws SQLException {
		String sql = "UPDATE APP.employees SET firstName = '"+ firstName+ "', lastName = '"+ lastName + "' , email = '" + email + "', username = '" + username + "' , password = '" + password + "' WHERE userID = "+ userID + "";
		PreparedStatement sqlPrepared = DBConnection.prepare(sql);
		int rs = sqlPrepared.executeUpdate();
	
	}
	
	public static int checkLogin(String username, String password) throws SQLException  {
		try {
			PreparedStatement stmt = DBConnection.prepare("SELECT userID " +
			         "  from APP.employees " +
			         "  WHERE username ='"+username+"' AND password ='"+password+"'");
			ResultSet rs = stmt.executeQuery();
			rs.next();			
			return rs.getInt(1);
		}
		catch(SQLException e){
			return -1;
			
		}
	}
	
	private static String stringSplit(String stm, String input, int place) {
		String str = stm.replaceAll("!"+place+"!", input);
		return str;
	}
	

}


