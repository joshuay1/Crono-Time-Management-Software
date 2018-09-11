package datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KeyTable {
	public static int getKey(String name) throws SQLException {
		int key = getKeyNumber(name);
		
		int nextKey = key + 1;

		setNextKey(name, nextKey);
		
		getKeyNumber(name);
		
		
		return key;
	}
	
	private static int getKeyNumber(String name) throws SQLException {
		//get the next key from the table
				String query = "SELECT  * FROM APP.keys";
				PreparedStatement queryPrepared = DBConnection.prepare(query);
				ResultSet rs = queryPrepared.executeQuery();
				rs.next();
				int key = -1;
				if(name == "timeID") {
					key = rs.getInt(3);
					
				}
				else if(name == "userID") {
					key = rs.getInt(2);
				}
				return key;
		
	}
	
	private static void setNextKey(String name, int nextKey) throws SQLException {
		//String update = "UPDATE APP.keys SET "+name+" = "+ nextKey + " WHERE location =1";
		String update = "UPDATE APP.keys SET " + name + "  =" + nextKey + " WHERE location = 2";
		PreparedStatement updateStatement = DBConnection.prepare(update);
		
		//queryPrepared.setString(0,name);
		//queryPrepared.setInt(1,nextKey);
		
		
		
		//queryPrepared = DBConnection.prepare(query);
		updateStatement.executeUpdate();
		
//		
//		String updateTableSQL = "UPDATE DBUSER SET USERNAME = ? "
//                + " WHERE USER_ID = ?";
//
//			try {
//			dbConnection = getDBConnection();
//			preparedStatement = dbConnection.prepareStatement(updateTableSQL);
//			
//			preparedStatement.setString(1, "mkyong_new_value");
//			preparedStatement.setInt(2, 1001);
//			
//			// execute update SQL stetement
//			preparedStatement.executeUpdate();
		
		
	}
	
//	String str;
//	str = stringSplit(insertStatement,""+id,0 );
//	str = stringSplit(str,""+timeID,1 );
//	str = stringSplit(str,startTime,2 );
//	str = stringSplit(str,finishTime,3 );
//	str = stringSplit(str,date,4 );
//	
//	PreparedStatement sqlPrepared = DBConnection.prepare(str);
//	sqlPrepared.executeUpdate();

}
