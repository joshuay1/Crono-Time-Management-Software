package domain;

public class Time {
	private int id;
	private String startTime; 
	private String finishTime;
	
	private String date;
	
	public Time(int id, String string, String string2, String date) {
		this.startTime = string;
		this.finishTime = string2;
		this.date = date;
		this.id = id;
	}
	public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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
