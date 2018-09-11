package domain;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.UserMapper;
import datasource.IdentityMap;
import datasource.KeyTable;
import datasource.TimeMapper;
import datasource.UnitOfWork;

public class Employee extends User {
	private int id;
	private List<Time> times = null;
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
    public static Time addTime(int userID, int timeID, String startTime, String finishTime, String date) {
    	Time t = new Time(userID, timeID, startTime, finishTime, date);
    	IdentityMap.addTime(t);
    	
    	return t;
    	
    }
    
    //lazy loader!
    private List<Time> getTimes() throws SQLException {
    	if(times == null) {
    		times = new ArrayList<Time>();
    		times = getTimeSheet();
    	}
    	return times;
    	
    }
    
    //add back
	public List<Time> getTimeSheet() throws SQLException {
        return TimeMapper.findMyTime(id);
	}
	
	
	public void instertTime(int userID, String startTime, String finishTime, String date) throws SQLException {
		int timeID = KeyTable.getKey("timeID");
		Time t = new Time(userID,timeID,startTime,finishTime,date);
		IdentityMap.addTime(t);

		//implementing UnitOfWork for adding new times
		UnitOfWork.newCurrent();
		
		//have to getTimes in case it is null; ------lazy initialisation 
		getTimes().add(t);

		UnitOfWork.getCurrent().registerNewTime(t);
		UnitOfWork.getCurrent().commit();
	}
	
	public int getNumberTimes() throws SQLException {
		return TimeMapper.numberTimes(id);
	}
	


	
	
	
	

}
