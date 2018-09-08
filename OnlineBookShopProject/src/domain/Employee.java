package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.EmployeeMapper;
import datasource.TimeFinder;
import datasource.TimeGateway;
import datasource.TimeMapper;

public class Employee extends User {
	private int id;
	private List<Time> times;
	public Employee(int id, String firstName, String lastName) {
		super( firstName, lastName);
		this.id = id;
		
		
		
	}
	public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
	
	
	//add mapper from database to history
	
//	public List<Time> getTimeSheet() throws SQLException {
//        List<Time> times = new ArrayList<Time>();
//		times = TimeMapper.findMyTime(id);
//        return times;
//	}
	public List<Time> getTimeSheet() throws SQLException {
        List<Time> times = new ArrayList<Time>();
		times = TimeMapper.findMyTime(id);
        return times;
	}
	
	
	public void instertTime(int ID, String startTime, String finishTime, String date) throws SQLException {
		TimeMapper.insert(ID,startTime,finishTime, date);
		Time t = new Time(ID,startTime,finishTime,date);
		times.add(t);
	}
	
	
	
	

}
