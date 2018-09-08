package datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeFinder {
	
	private final static String findStatementString =
	         "SELECT * " +
	         "  from APP.times ";
	         //"  WHERE id = ?";
	 private static final String findAllTimesStatement =
	         "SELECT * from APP.times";
	 
	 
	public TimeGateway find(int id) {
          TimeGateway result = Registry.getTime(id);
	      if (result  != null) 
	    	  return result;
	      PreparedStatement findStatement = null;
	      ResultSet rs = null;
	      try {
	         findStatement = DBConnection.prepare(findStatementString);
	         findStatement.setInt(1, id);
	         rs = findStatement.executeQuery();
	         rs.next();
	         result = TimeGateway.load(rs);
	          
	      } catch (SQLException e) {
	      }
	      return result;
	   }


    public List<TimeGateway> findAllTimes() {
	      List<TimeGateway> result = new ArrayList<>();
	      try {

		        PreparedStatement stmt = DBConnection.prepare(findAllTimesStatement);
	
	        	 ResultSet rs = stmt.executeQuery();
		         while (rs.next()) {
			         int id =  rs.getInt(1);
			         String startTime = rs.getString(2);
			         String finishTime = rs.getString(3);
			         String date = rs.getString(4);
			         result.add( new TimeGateway(id, startTime, finishTime, date));
		         }
		         
//	         while (rs.next()) {
//	            result.add(BookGateway.load(rs));
//	         }
	      } catch (SQLException e) {
	      
	      }
	      return result;
	   }

}
