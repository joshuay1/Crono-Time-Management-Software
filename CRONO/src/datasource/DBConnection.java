package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	private static final String DB_URL = "jdbc:postgresql://ec2-75-101-153-56.compute-1.amazonaws.com:5432/d17deg7ubgb4us?user=eeljkplxctdqlz&password=d3fc7da85d1ba7df8c5b4a7921b47f581ce0bc95a95fc144155e5da7f72e0ae0&sslmode=require";
	private static final String DB_USER = "eeljkplxctdqlz";
	private static final String DB_PASSWORD = "d3fc7da85d1ba7df8c5b4a7921b47f581ce0bc95a95fc144155e5da7f72e0ae0";
	
	
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


		//String dbUrl = System.getenv("JDBC_DATABASE_URL");
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());

			Connection dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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