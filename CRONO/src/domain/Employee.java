package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.UserMapper;
import datasource.KeyTable;
import datasource.TimeMapper;
import datasource.UnitOfWork;

public class Employee extends User {
	private int id;
	private List<Time> times = new ArrayList<Time>();;
	public Employee(int id, String firstName, String lastName, String email, String userName, String password) {
		super( firstName, lastName, email, userName, password);
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
		times = TimeMapper.findMyTime(id);
        return times;
	}
	
	
	public void instertTime(int userID, String startTime, String finishTime, String date) throws SQLException {
		int timeID = KeyTable.getKey("timeID");
		Time t = new Time(userID,timeID,startTime,finishTime,date);
		unitOfWork.registerNewTime(t);
		times.add(t);
	}
	


	
	
	
	

}
