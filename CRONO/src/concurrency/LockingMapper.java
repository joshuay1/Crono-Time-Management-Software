package concurrency;

import java.sql.SQLException;

import datasource.TimeMapper;
import datasource.UserMapper;
import domain.Time;
import domain.User;

public class LockingMapper implements Mapper{
	private String sessionID;
	
	
	public LockingMapper() {
		//this.sessionID = SessionManager.getSession().getI
	}
	
	public void updateUser(User obj) throws SQLException, InterruptedException {
		UserMapper.update(obj.getID(), obj.getFirstName(), obj.getLastName(), obj.getEmail(),obj.getUserName(),obj.getPassword(),obj.getVersionN());
	}
	
	public void updateTime(Time obj) throws SQLException {
		TimeMapper.update(obj.getUserID(),obj.getTimeID(), obj.getStartTime(),obj.getFinishTime(),obj.getDate(),obj.getVersion());
	}
	
	
	

}
