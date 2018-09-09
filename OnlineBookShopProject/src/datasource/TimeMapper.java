package datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Time;

public class TimeMapper {
	private final static String findStatementString =
	         "SELECT * " +
	         "  from APP.times "+
	         "  WHERE ID = !1!";
	
	 private static final String findAllTimesStatement =
	         "SELECT * from APP.times";
	 
	 private static final String insertStatement =
			 
			 "INSERT INTO APP.times VALUES (!0!, '!1!', '!2!','!3!')";
	
	public static List<Time> findMyTime(int myID) throws SQLException {
		String str = stringSplit(findStatementString, ""+myID, 1);
		PreparedStatement sqlPrepared = DBConnection.prepare(str);
		ResultSet rs = sqlPrepared.executeQuery();
		List<Time> result = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt(1);
			String startTime = rs.getString(2);
	        String finishTime = rs.getString(3);
	        String date = rs.getString(4);
	        Time time = new Time(id, startTime, finishTime, date);
			result.add(time);
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
	
	
	public static void insert(int id, String startTime, String finishTime, String date) throws SQLException{
		String str;
		str = stringSplit(insertStatement,""+id,0 );
		str = stringSplit(str,startTime,1 );
		str = stringSplit(str,finishTime,2 );
		str = stringSplit(str,date,3 );
		
		PreparedStatement sqlPrepared = DBConnection.prepare(str);
		int rs = sqlPrepared.executeUpdate();
		
	}
	
	
	private static String stringSplit(String stm, String input, int place) {
		String str = stm.replaceAll("!"+place+"!", input);
		return str;
	}

}
