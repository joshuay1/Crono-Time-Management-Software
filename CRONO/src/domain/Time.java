package domain;

import java.sql.SQLException;

import datasource.TimeMapper;
import datasource.UnitOfWork;

public class Time {
	private int userID;
	private int timeID;
	private String startTime; 
	private String finishTime;
	
	
	private String date;
	private int paid;
	private int version;
	public Time(int userID, int timeID, String startTime, String finishTime, String date, int paid,int version) {
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.date = date;
		this.userID = userID;
		this.timeID = timeID;
		this.paid = paid;
		this.version = version;
	}
	
	
	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public int getTimeID() {
        return timeID;
    }

    public void setTimeID(int timeID) {
        this.timeID = timeID;
    }
	
	public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    public static Pay createPay(float pay, String startTime, String finishTime) {
    	Pay p = new Pay(pay, startTime, finishTime,1);
    	return p;
    }
    
    public String getPay() throws SQLException {
    	Pay pay = TimeMapper.createPay(timeID);
    	
    	
    	return pay.getString();
    }
    
    
    
	
	
	
	
	
}
