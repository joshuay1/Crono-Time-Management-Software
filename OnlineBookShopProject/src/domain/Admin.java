package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.EmployeeMapper;

public class Admin {
	
	
	public static TimeSheet getAllTimes(List<Employee> e) throws SQLException {
		TimeSheet timeSheet = new TimeSheet();
		timeSheet.setTimeSheet(e);
		return timeSheet;
		
	}
	


}
