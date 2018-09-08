package domain;

import java.util.ArrayList;
import java.util.List;

import datasource.TimeFinder;
import datasource.TimeGateway;

public class Employee extends User {
	
	private TimeSheet timeSheet;
	public Employee(String email, String name, String address) {
		super(email, name, address);
		timeSheet = new TimeSheet();
		
	}
	
	
	//add mapper from database to history
	
	public static List<Time> getTimeSheet() {
		TimeFinder finder = new TimeFinder();
        List<Time> result = new ArrayList<Time>();
        List<TimeGateway> timeRecords = finder.findAllTimes();

        for (TimeGateway t : timeRecords) {
            Time time = new Time(String.valueOf(t.getId()), t.getStartTime(), t.getFinishTime(), t.getDate());
            result.add(time);

        }

        return result;
	}
	
	

}
