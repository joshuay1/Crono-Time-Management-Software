package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.EmployeeMapper;
import datasource.TimeFinder;
import datasource.TimeGateway;
import datasource.TimeMapper;

public class Employee extends User {
	private static int id;
	private TimeSheet timeSheet;
	public Employee(int id, String firstName, String lastName) {
		super( firstName, lastName);
		timeSheet = new TimeSheet();
		this.id = id;
		
		
	}
	public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
	
	
	//add mapper from database to history
	
	public List<Time> getTimeSheet() throws SQLException {
        List<Time> times = new ArrayList<Time>();
		times = TimeMapper.findMyTime(id);
        return times;
	}
	
	
	
	

}
