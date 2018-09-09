package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeSheet {
	private List<String> firstNames= new ArrayList();
	private List<String> lastNames= new ArrayList();
	private List<Integer> ids = new ArrayList();
	private List<String> startTimes= new ArrayList();
	private List<String> finishTimes= new ArrayList();
	private List<String> dates= new ArrayList();
	
	public void setTimeSheet(List<Employee> employees) throws SQLException{
		//going through all times within each employee and adding the info stored in all their time objects
		for(Employee e: employees) {
			List<Time> times = e.getTimeSheet();
			for(Time time: times) {
				ids.add(e.getID());
				firstNames.add(e.getFirstName());
				lastNames.add(e.getLastName());
				startTimes.add(time.getStartTime());
				finishTimes.add(time.getFinishTime());
				dates.add(time.getDate());
			}
		}
	}
	
	public List<Integer> getIDs() {
        return ids;
    }
	public Integer getIDs(int i) {
        return ids.get(i);
    }

	
	public String getStartTimes(int i) {
        return startTimes.get(i);
    }


    public String getFinishTimes(int i) {
        return finishTimes.get(i);
    }


    public String getDates(int i) {
        return dates.get(i);
    }
    public String getFirstNames(int i) {
        return firstNames.get(i);
    }

    
    public String getLastNames(int i) {
        return lastNames.get(i);
    }
	
	
}
