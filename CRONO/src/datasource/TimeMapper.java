package datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Employee;
import domain.Pay;
import domain.Time;


//use class inheritance pattern
public class TimeMapper {
	private final static String findStatementString =
	         "SELECT * " +
	         "  from APP.times "+
	         "  WHERE userID = !1!";
	
	 private static final String findAllTimesStatement =
	         "SELECT * from APP.times";
	 
	 private static final String insertStatement =
			 
			 "INSERT INTO APP.times VALUES (!0!, !1!, '!2!','!3!','!4!')";
	 
	 private static final String updateStatement =
			 
			 "UPDATE APP.times SET userID = !0!,startTime= !2!,finishTime = !3!, date = !4!, WHERE timeID = !1!)";
	 
	 private static final String deleteStatement =
			 
			 "DELETE APP.times  WHERE timeID = !1!)";
	
	public static List<Time> findMyTime(int myID) throws SQLException {
		String str = stringSplit(findStatementString, ""+myID, 1);
		PreparedStatement sqlPrepared = DBConnection.prepare(str);
		ResultSet rs = sqlPrepared.executeQuery();
		List<Time> result = new ArrayList();
		while (rs.next()) {
			int userID = rs.getInt(1);
			int timeID = rs.getInt(2);
			String startTime = rs.getString(3);
	        String finishTime = rs.getString(4);
	        String date = rs.getString(5);
	        Time t = Employee.addTime(userID,timeID, startTime, finishTime, date);
	        result.add(t);
		}
		return result;
	}
//	public static List<Time> findAllTime() throws SQLException {
//		PreparedStatement sqlPrepared = DBConnection.prepare(findAllTimesStatement);
//		ResultSet rs = sqlPrepared.executeQuery();
//		List<Time> result = new ArrayList();
//		while (rs.next()) {
//			int id = rs.getInt(1);
//			String startTime = rs.getString(2);
//	        String finishTime = rs.getString(3);
//	        String date = rs.getString(4);
//	        Time time = new Time(id, startTime, finishTime, date);
//			result.add(time);
//		}
//		return result;
//	}
	
	
	
	
	public static void insert(int id, int timeID, String startTime, String finishTime, String date) throws SQLException{
		String str;
		str = stringSplit(insertStatement,""+id,0 );
		str = stringSplit(str,""+timeID,1 );
		str = stringSplit(str,startTime,2 );
		str = stringSplit(str,finishTime,3 );
		str = stringSplit(str,date,4 );
		
		PreparedStatement sqlPrepared = DBConnection.prepare(str);
		sqlPrepared.executeUpdate();
		
	}
	
	
	public static void update(int id,int timeID, String startTime, String finishTime, String date) throws SQLException{
		String str;
		str = stringSplit(updateStatement,""+id,0 );
		str = stringSplit(str,""+timeID,1 );
		str = stringSplit(str,startTime,2 );
		str = stringSplit(str,finishTime,3 );
		str = stringSplit(str,date,4 );
		
		PreparedStatement sqlPrepared = DBConnection.prepare(str);
		int rs = sqlPrepared.executeUpdate();
		
	}
	
	public static void delete(int timeID) throws SQLException{
		String str;
		str = stringSplit(deleteStatement,""+timeID,1 );
		
		PreparedStatement sqlPrepared = DBConnection.prepare(str);
		int rs = sqlPrepared.executeUpdate();
		
	}
	
	//user - time association mapping
		public static int numberTimes(int userID) throws SQLException {
			String sql = "SELECT COUNT(TimeID) "+ 
					 " FROM APP.times INNER JOIN APP.employees ON APP.times.userID = APP.employees.userID " +
					 " WHERE APP.employees.userID = "+userID+"";
			PreparedStatement sqlPrepared = DBConnection.prepare(sql);
			ResultSet rs = sqlPrepared.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			
			return count;
			
		}
		
		
		
		//embedded pattern!
		public static Pay createPay(int timeID) throws SQLException {
			String sql = "SELECT * "+
						"FROM APP.times "+
						"WHERE timeID = " + timeID;
			PreparedStatement sqlPrepared = DBConnection.prepare(sql);
			ResultSet rs = sqlPrepared.executeQuery();
			rs.next();
			String startTime = rs.getString(3);
			String finishTime = rs.getString(4);
			int userID = rs.getInt(1);
			//embedded!
			float pay = PayMapper.getPay(userID);
			return Time.createPay(pay, startTime, finishTime);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	private static String stringSplit(String stm, String input, int place) {
		String str = stm.replaceAll("!"+place+"!", input);
		return str;
	}
	
	


}
