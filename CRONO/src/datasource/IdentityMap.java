package datasource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Admin;
import domain.Employee;
import domain.Time;
import domain.User;

public class IdentityMap {
	
    private static Map<Integer, Employee> employees = new HashMap<>();
    private static Map<Integer, Admin> admins = new HashMap<>();
    private static Map<Integer, Time> times = new HashMap<>();
    private static Map<Integer,ArrayList<Time>> personalTimes = new HashMap<Integer, ArrayList<Time>>();

    public static Time getTime(int timeID) {
        return times.get(timeID);
	}

	public static void addTime(Time time) {
        IdentityMap.times.put(time.getTimeID(), time);
        if(IdentityMap.personalTimes.containsKey(time.getUserID())) {
            //Add to existing list
        	IdentityMap.personalTimes.get(time.getUserID()).add(time);

        } else {
            //Create new list
            ArrayList<Time> times = new ArrayList<Time>(1);
            times.add(time);
            IdentityMap.personalTimes.put(time.getUserID(),times);
        }
        //IdentityMap.personalTimes.get(time.getUserID()).add(time); //adding to List<Time>
    }

    public static Admin getAdmin(int userID) {
        if(admins.containsKey(userID)) {
        	return admins.get(userID);
        }
        else return null;
    }
    public static Employee getEmployee(int userID) {
        if(employees.containsKey(userID)) {
        	return employees.get(userID);
        }
        else return null;
    }

    public static void addAdmin(Admin user) {
    	IdentityMap.admins.put(user.getID(), user);
    	
    }
    public static void addEmployee(Employee user) {
    	IdentityMap.employees.put(user.getID(), user);
    	
    }
    
    public static List<Time> getPersonalTimes(int userID){
    	return personalTimes.get(userID);
    }
    

	
}
