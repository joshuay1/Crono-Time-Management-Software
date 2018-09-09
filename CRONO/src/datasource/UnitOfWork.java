package datasource;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.tools.javac.util.Assert;

import domain.Time;

public class UnitOfWork {
	private List<Time> newTimeObjects = new ArrayList<Time>();
	private List<Time> dirtyTimeObjects = new ArrayList<Time>();
	private List<Time> deletedTimeObjects = new ArrayList<Time>();
	
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
		Assert.checkNonNull(obj, "Time is null");
		Assert.check(!dirtyTimeObjects.contains(obj), "Time is dirty");
		Assert.check(!deletedTimeObjects.contains(obj), "Time is deleted");
		Assert.check(!newTimeObjects.contains(obj), "Time is new");
		newTimeObjects.add(obj);
	}
	
	public void registerDirty(Time obj) {
		Assert.checkNonNull(obj.getUserID(), "id is null");
		Assert.check(!deletedTimeObjects.contains(obj), "Time is deleted");
		newTimeObjects.add(obj);
	}
	
	public void registerDeleted(Time obj) {
		Assert.checkNonNull(obj.getUserID(), "id is null");
		if (newTimeObjects.remove(obj)) return;
			dirtyTimeObjects.remove(obj);
		if (!deletedTimeObjects.contains(obj)) {
			deletedTimeObjects.add(obj);
		}
	}
	
	
	public void registerClean(Time obj) {
		Assert.checkNonNull(obj.getUserID(), "id is null");
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
	}
}
