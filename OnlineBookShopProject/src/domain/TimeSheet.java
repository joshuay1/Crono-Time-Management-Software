package domain;

import java.util.List;

public class TimeSheet {
	private List<Time> history;
	public TimeSheet(List<Time> history) {
		this.history = history;
	}
	public TimeSheet() {
	}

	public List<Time> getHistory(){
		return history;
	}
	
	public void setHistory(List<Time> history) {
		this.history =history;
	}
	public void addHistory(Time time) {
		history.add(time);
	}
	
	
}
