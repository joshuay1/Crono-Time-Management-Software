package datasource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Time;

public class TimeGateway {
	private int id;
	 private String  startTime;
	 private String  finishTime;
	 private String  date;
	 private static final String updateStatementString =
	         "UPDATE APP.times " +
                     "  set startTime = ?, finishTime = ?, date = ?" +
                     "  where isbn = ?";
	
	 private static final String insertStatementString =
	         "INSERT INTO APP.times VALUES (?, ?, ?, ?)";


    public TimeGateway(int id, String startTime, String finishTime, String date) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.date = date;
    }

	public TimeGateway() {
	}

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setPrice(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
   public void update() {
      PreparedStatement updateStatement = null;
      try {
         updateStatement = DBConnection.prepare(updateStatementString);
         updateStatement.setString(1, startTime);
         updateStatement.setString(2, finishTime);
         updateStatement.setString(3, date);
         updateStatement.setInt(4, id);

         updateStatement.execute();
      } catch (Exception e) {
    
      }
   }
		  
   public int insert() {
      PreparedStatement insertStatement = null;
      try {
         insertStatement = DBConnection.prepare(insertStatementString);
         insertStatement.setInt(1,id);
         insertStatement.setString(2, startTime);
         insertStatement.setString(3, finishTime);
         insertStatement.setString(4, date);

         insertStatement.execute();
         Registry.addTime(this);
      } catch (SQLException e) {
      }
      return getId();

   }

    public static TimeGateway load(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        TimeGateway result = Registry.getTime(id);
        if (result != null)
            return result;
        String startTime = rs.getString(2);
        String finishTime = rs.getString(3);
        String date = rs.getString(4);
        result = new TimeGateway(id, startTime, finishTime, date);
        Registry.addTime(result);
        return result;
    }
}
