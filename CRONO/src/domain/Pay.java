package domain;

public class Pay {
	private float payRate;
	private String startTime;
	private String finishTime;
	
	
	public Pay(float payRate, String startTime, String finishTime) {
		this.payRate = payRate;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	
	
	public String getString() {
		return "("+finishTime + " - " + startTime + ") * " + payRate;
	}

}
