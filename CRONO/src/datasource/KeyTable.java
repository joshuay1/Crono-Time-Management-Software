package datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KeyTable {
	public static int getKey(String name) throws SQLException {
		//get the next key from the table
		String query = "SELECT "+name + " FROM keys";
		PreparedStatement queryPrepared = DBConnection.prepare(query);
		ResultSet rs = queryPrepared.executeQuery();
		rs.next();
		int key = rs.getInt(1);
		int nextKey = key + 1;
		String update = "UPDATE keys SET "+name+" = "+ nextKey + "WHERE location =1";
		queryPrepared = DBConnection.prepare(query);
		rs = queryPrepared.executeUpdate();
		return key;
	}

}
