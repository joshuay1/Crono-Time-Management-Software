package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/crono;create=true";
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

	

	/**
	 * @return
	 */
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
	
//	public static PreparedStatement prepare(String stm, int returnGeneratedKeys) {
//        PreparedStatement preparedStatement = null;
//        try {
//
//            Connection dbConnection = getDBConnection();
//
//            preparedStatement = dbConnection.prepareStatement(stm, Statement.RETURN_GENERATED_KEYS);
//
//
//        } catch (SQLException e) {
//
//            System.out.println(e.getMessage());
//
//
//        }
//
//        return preparedStatement;
//    }
	
	


}