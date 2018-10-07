package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.IdentityMap;
import datasource.KeyTable;
import datasource.TimeMapper;
import datasource.UnitOfWork;

public class Employee extends User {
	private List<Time> times = null;
	public Employee(int id, String firstName, String lastName, String email, String userName, String password, String role, int versionN) {
		super( firstName, lastName, email, userName, password,id,role,versionN);
		
		
		
	}
	
    
    
	
	
	//add mapper from database to history
	
//	public List<Time> getTimeSheet() throws SQLException {
//        List<Time> times = new ArrayList<Time>();
//		times = TimeMapper.findMyTime(id);
//        return times;
//	}
    public static Time addTime(int userID, int timeID, String startTime, String finishTime, String date, int paid, int version) {
    	Time t = new Time(userID, timeID, startTime, finishTime, date, paid,version);
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
	
	
	public void instertTime(int userID, String startTime, String finishTime, String date, int paid) throws SQLException {
		int timeID = KeyTable.getKey("timeID");
		Time t = new Time(userID,timeID,startTime,finishTime,date, paid,1);
		IdentityMap.addTime(t);

		//implementing UnitOfWork for adding new times
		UnitOfWork.newCurrent();
		
		//have to getTimes in case it is null; ------lazy initialisation 
		getTimes().add(t);

		UnitOfWork.getCurrent().registerNewTime(t);
		UnitOfWork.getCurrent().commit();
	}
	
	public int getNumberTimes() throws SQLException {
		return times.size();
	}
	
	public static void payTime(int timeID) {
		try {
			TimeMapper.payTime(timeID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	
	
	
	

}
