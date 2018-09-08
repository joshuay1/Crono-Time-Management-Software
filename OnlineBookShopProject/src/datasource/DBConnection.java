package datasource;
import java.sql.*;

public class DBConnection {
	
	private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/ebookshop;create=true";
	private static final String DB_USER = "user";
	private static final String DB_PASSWORD = "123";
	
	
	public static PreparedStatement prepare(String stm) throws SQLException {
		 
		PreparedStatement preparedStatement = null;
		try {	
	
	       	 Connection dbConnection = getDBConnection();
				
			preparedStatement = dbConnection.prepareStatement(stm);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		
		}

		return preparedStatement;
	}
	public static PreparedStatement prepare(String stm,int id) throws SQLException {
		stm = stringSplit(stm,id);
		 
		PreparedStatement preparedStatement = null;
		try {	
	
	       	 Connection dbConnection = getDBConnection();
				
			preparedStatement = dbConnection.prepareStatement(stm);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		
		}

		return preparedStatement;
	}
	private static Connection getDBConnection() {



		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());

			Connection dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		System.out.println("Connection problem");
		return null;

	}
	
	
	
	private static String stringSplit(String stm, int id) {
		String str = stm.replaceAll("!!", ""+id);
		System.out.println(id);
		//System.exit(0);
		return str;
	}

}
