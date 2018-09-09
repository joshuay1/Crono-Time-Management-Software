package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.UserMapper;

public class Roster {
	
	static List<Employee> employees = new ArrayList<Employee>();
	
	public static List<Employee> getUsers() throws SQLException {
        employees = UserMapper.allEmployees();
        return employees;
	}
	
	
	public static Employee getEmployee(int id)throws SQLException {
		Employee e = UserMapper.getEmployee(id);
		return e;
	}
	

}
