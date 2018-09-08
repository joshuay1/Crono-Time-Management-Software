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
	         "  WHERE id = !!";
	
	 private static final String findAllTimesStatement =
	         "SELECT * from APP.times";
	
	public static List<Time> findMyTime(int myID) throws SQLException {
		PreparedStatement sqlPrepared = DBConnection.prepare(findStatementString,myID);
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

}
