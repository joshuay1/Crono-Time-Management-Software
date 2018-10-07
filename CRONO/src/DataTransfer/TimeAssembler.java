package DataTransfer;

import domain.Time;

public class TimeAssembler {
	
	
	public TimeDTO writeDTO(Time time) {
		TimeDTO t = new TimeDTO();
		t.setTimeID(time.getTimeID());
		t.setStartTime(t.getStartTime());
		t.setFinishTime(t.getFinishTime());
		t.setDate(t.getDate());
		t.setPaid(t.getPaid());
		
		return t;
		
	}
	public TimeDTO update(Time time, TimeDTO t) {
		t.setTimeID(time.getTimeID());
		t.setStartTime(t.getStartTime());
		t.setFinishTime(t.getFinishTime());
		t.setDate(t.getDate());
		t.setPaid(t.getPaid());
		
		return t;
		
	}

}
