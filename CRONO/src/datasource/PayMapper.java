package datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//class inheritance pattern;
public class PayMapper {
	public static float getPay(int userID) throws SQLException {
		String sql = "SELECT payAmount " +
					" FROM APP.pay " +
					"WHERE userID = " + userID;
		PreparedStatement sqlPrepared = DBConnection.prepare(sql);
		ResultSet rs = sqlPrepared.executeQuery();
		
		rs.next();
		return  rs.getFloat(1);
		
	}
}
