package domain;

public class Pay {
	private float payRate;
	private String startTime;
	private String finishTime;
	private int version;
	
	
	public Pay(float payRate, String startTime, String finishTime,int version) {
		this.payRate = payRate;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.version = version;
	}
	
	
	public String getString() {
		return "("+finishTime + " - " + startTime + ") * " + payRate;
	}

}
