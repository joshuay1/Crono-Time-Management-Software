package datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import domain.Employee;

public class EmployeeMapper {
	private final static String findStatementString =
	         "SELECT * " +
	         "  from APP.times ";
	         //"  WHERE id = ?";
	
	 private static final String findAllTimesStatement =
	         "SELECT * from APP.times";
	
	public static List<Employee> allEmployees() {
		PreparedStatement sqlPrepared = DBConnection.prepare(findAllTimesStatement);
		ResultSet rs = sqlPrepared.executeQuery();
		List<Employee> result = new ArrayList();
		while (rs.next()) {
			long rsId = rs.getLong(1);
			String rsLastName = rs.getString(2);
			String rsFirstName = rs.getString(3);
			int rsNumberOfDependents = rs.getInt(4);
			Person person =new Person(rsId, rsLastName, rsFirstName, rsNumberOfDependents);
			result.add(person);
			}
		return result;
	}

}
