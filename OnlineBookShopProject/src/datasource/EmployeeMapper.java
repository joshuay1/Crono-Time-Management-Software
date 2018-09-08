package datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Employee;

public class EmployeeMapper {
	private final static String findStatementString =
	         "SELECT * " +
	         "  from APP.employees ";
	        // "  WHERE id = {0}";
	
	 private static final String findAllTimesStatement =
	         "SELECT * from APP.employees";
	
	public static List<Employee> allEmployees() throws SQLException {
		try {
			PreparedStatement sqlPrepared = DBConnection.prepare(findAllTimesStatement);
			ResultSet rs = sqlPrepared.executeQuery();
			List<Employee> result = new ArrayList<Employee>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				Employee employee =new Employee(id, firstName, lastName);
				result.add(employee);
			}
			return result;
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		return null;
	}

}
