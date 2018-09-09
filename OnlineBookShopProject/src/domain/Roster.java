package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.EmployeeMapper;

public class Roster {
	
	public static List<Employee> getUsers() throws SQLException {
        List<Employee> employees = new ArrayList<Employee>();
        employees = EmployeeMapper.allEmployees();
        return employees;
	}
	
	
	public static Employee getEmployee(int id)throws SQLException {
		Employee e = EmployeeMapper.getEmployee(id);
		return e;
	}
	

}
