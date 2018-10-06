package datasource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Employee;
import domain.Time;
import domain.User;

public class IdentityMap {
	
    private static Map<Integer, User> users = new HashMap<>();
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

    public static User getUser(int userID) {
        if(users.containsKey(userID)) {
        	return users.get(userID);
        }
        else return null;
    }

    public static void addUser(User user) {
    	IdentityMap.users.put(user.getID(), user);
    }
    
    public static List<Time> getPersonalTimes(int userID){
    	return personalTimes.get(userID);
    }
    

	
}
