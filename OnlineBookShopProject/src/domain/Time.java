package domain;

public class Time {
	private String isbn;
	private String startTime; 
	private String finishTime;
	
	private String date;
	
	public Time(String isbn, String string, String string2, String date) {
		this.startTime = string;
		this.finishTime = string2;
		this.date = date;
		this.isbn = isbn;
	}
	public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
