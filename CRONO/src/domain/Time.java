package domain;

public class Time {
	private int userID;
	private int timeID;
	private String startTime; 
	private String finishTime;
	
	
	private String date;
	
	public Time(int userID, int timeID, String string, String string2, String date) {
		this.startTime = string;
		this.finishTime = string2;
		this.date = date;
		this.userID = userID;
		this.timeID = timeID;
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
    
    
    
    
	
	
	
	
	
}
