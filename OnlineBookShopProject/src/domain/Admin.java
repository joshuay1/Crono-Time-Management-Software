package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.EmployeeMapper;
import datasource.TimeFinder;
import datasource.TimeGateway;

public class Admin {
	
	public static List<Employee> getUsers() throws SQLException {
        List<Employee> employees = new ArrayList<Employee>();
        employees = EmployeeMapper.allEmployees();
        return employees;
	}
	
	public static TimeSheet getAllTimes(List<Employee> e) throws SQLException {
		TimeSheet timeSheet = new TimeSheet();
		timeSheet.setTimeSheet(e);
		return timeSheet;
		
		
	}
	

}
