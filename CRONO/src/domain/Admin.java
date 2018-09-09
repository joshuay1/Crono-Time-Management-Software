package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.UserMapper;

public class Admin {
	
	
	public static TimeSheet getAllTimes(List<Employee> e) throws SQLException {
		TimeSheet timeSheet = new TimeSheet();
		timeSheet.setTimeSheet(e);
		return timeSheet;
		
	}
	


}
