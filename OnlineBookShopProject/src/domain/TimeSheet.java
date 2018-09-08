package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeSheet {
	public static List<List<Time>> timeSheet(List<Employee> employees) throws SQLException{
		ArrayList<List<Time>> list = new ArrayList();
		List<Time> time = new ArrayList<Time>();
		for(Employee e: employees) {
			time = e.getTimeSheet();
			list.add(time);
		}
		
		return list;
		
		
	}
	
	
}
