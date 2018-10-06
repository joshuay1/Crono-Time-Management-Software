package datasource;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import domain.User;
import domain.Time;

public class UnitOfWork {
	private List<Time> newTimeObjects = new ArrayList<Time>();
	private List<Time> dirtyTimeObjects = new ArrayList<Time>();
	private List<Time> deletedTimeObjects = new ArrayList<Time>();
	private List<User> dirtyUserObjects = new ArrayList<User>();
	private List<User> deletedUserObjects = new ArrayList<User>();

	
	private String hello = "";
	
	private static ThreadLocal current = new ThreadLocal();
	
	public static void newCurrent() {
	 setCurrent(new UnitOfWork());
	}
	public static void setCurrent(UnitOfWork uow) {
		current.set(uow);
	}
	public static UnitOfWork getCurrent() {
		return (UnitOfWork) current.get();
	}
	
	public void registerNewTime(Time obj) {
//		if(obj != null) {
//			System.out.println("hello");
//			System.exit(0);
//		}
//		assertNotNull(obj);
//		assertTrue(!dirtyTimeObjects.contains(obj));
//		assertTrue(!deletedTimeObjects.contains(obj));
//		assertTrue(!newTimeObjects.contains(obj));
		System.out.println("insert");
		hello = "insert";
		newTimeObjects.add(obj);
	}
	
	public void registerDirtyTime(Time obj) {
//		assertNotNull(obj.getUserID());
//		assertTrue(!deletedTimeObjects.contains(obj));
		dirtyTimeObjects.add(obj);
	}
	
	public void registerDeletedTime(Time obj) {
//		assertNotNull(obj.getUserID());
		if (newTimeObjects.remove(obj)) return;
			dirtyTimeObjects.remove(obj);
		if (!deletedTimeObjects.contains(obj)) {
			deletedTimeObjects.add(obj);
		}
	}
	
	public void registerDeleteUser(User obj) {
		deletedUserObjects.add(obj);
	}
	
	
	public void registerDirtyUser(User obj) {
		dirtyUserObjects.add(obj);
		
		
	}
	
	
	public void registerClean(Time obj) {
		assertNotNull(obj.getUserID());
	}
	
	
	public void commit() throws SQLException {
		
		for (Time obj : newTimeObjects) {
			TimeMapper.insert(obj.getUserID(),obj.getTimeID(), obj.getStartTime(),obj.getFinishTime(),obj.getDate());
		}
		for (Time obj : dirtyTimeObjects) {
			TimeMapper.update(obj.getUserID(),obj.getTimeID(), obj.getStartTime(),obj.getFinishTime(),obj.getDate());
		}
		for (Time obj : deletedTimeObjects) {
			TimeMapper.delete(obj.getTimeID());
		}
		for(User obj: dirtyUserObjects) {
			UserMapper.update(obj.getID(), obj.getFirstName(), obj.getLastName(), obj.getEmail(),obj.getUserName(),obj.getPassword());
		}
		for(User obj: deletedUserObjects) {
			UserMapper.delete(obj.getID(), obj.getFirstName(), obj.getLastName(), obj.getEmail(),obj.getUserName(),obj.getPassword());
		}
	}
}
