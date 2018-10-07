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
			 
			 "INSERT INTO APP.times VALUES (!0!, !1!, '!2!','!3!','!4!', 0,1)";
	 
	 private static final String updateStatement =
			 
			 "UPDATE APP.times SET userID = !0!,startTime= !2!,finishTime = !3!, date = !4!, WHERE timeID = !1!)";
	 
	 private static final String deleteStatement =
			 
			 "DELETE APP.times  WHERE timeID = !1!)";
	
	public static List<Time> findMyTime(int myID) throws SQLException {
		//only accessing once no need for optimistic lock
		String sql = "SELECT * "+
				"FROM APP.times WHERE userID = "+myID;
		PreparedStatement sqlPrepared = DBConnection.prepare(sql);
		ResultSet rs = sqlPrepared.executeQuery();
		List<Time> result = new ArrayList();
		while (rs.next()) {
			int userID = rs.getInt(1);
			int timeID = rs.getInt(2);
			String startTime = rs.getString(3);
	        String finishTime = rs.getString(4);
	        String date = rs.getString(5);
	        int paid = rs.getInt(6);
	        int version = rs.getInt(7);
	        Time t = new Time(userID,timeID, startTime, finishTime, date,paid,version);
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
	
	
	public static void update(int id,int timeID, String startTime, String finishTime, String date,int version) throws SQLException{
		String str = "SELECT * "+
				"FROM APP.times "+
				"WHERE timeID = " + timeID;
		PreparedStatement preparedSQL = DBConnection.prepare(str);
		ResultSet rs = preparedSQL.executeQuery();
		if(rs.next()) {
			int rsVersion = rs.getInt(8);
			//checking version
			if(rsVersion != version) {
				try {
					throw new InterruptedException("Row " + timeID + "in table user was by modified");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				
				String sql = stringSplit(updateStatement,""+id,0 );
				sql = stringSplit(str,""+timeID,1 );
				sql = stringSplit(str,startTime,2 );
				sql = stringSplit(str,finishTime,3 );
				sql = stringSplit(str,date,4 );
				
				PreparedStatement sqlPrepared = DBConnection.prepare(str);
				sqlPrepared.executeUpdate();
			}
		}else {
			System.out.print("Time has been deleted");
		}
		
		
		
		
		
	
		
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
					 " FROM APP.times INNER JOIN APP.users ON APP.times.userID = APP.users.userID " +
					 " WHERE APP.users.userID = "+userID+"";
			PreparedStatement sqlPrepared = DBConnection.prepare(sql);
			ResultSet rs = sqlPrepared.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			
			return count;
			
		}
		
		public static void payTime(int id) throws SQLException {
			String sql = "UPDATE APP.times SET paid = "+1+" WHERE timeID = "+ id + "";
			PreparedStatement sqlPrepared = DBConnection.prepare(sql);
			int rs = sqlPrepared.executeUpdate();
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
		
		
		public static Time getTime(int timeID) {
			try {
				String sql = "SELECT * "+
						"FROM APP.times "+
						"WHERE timeID = " + timeID;
				PreparedStatement sqlPrepared;
				
				sqlPrepared = DBConnection.prepare(sql);
				ResultSet rs = sqlPrepared.executeQuery();
				rs.next();
				int userID = rs.getInt(1);
				int timeIDs = rs.getInt(2);
				String startTime = rs.getString(3);
				String finishTime = rs.getString(4);
				String date = rs.getString(5);
				int paid = rs.getInt(6);
				int version = rs.getInt(7);
				Time t = new Time(userID, timeIDs, startTime, finishTime, date, paid,version);
				return t;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	private static String stringSplit(String stm, String input, int place) {
		String str = stm.replaceAll("!"+place+"!", input);
		return str;
	}
	
	


}
