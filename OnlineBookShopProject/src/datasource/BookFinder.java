package datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookFinder {
	
	private final static String findStatementString =
	         "SELECT * " +
	         "  from APP.books " +
	         "  WHERE id = ?";
	 private static final String findAvaliableBooksStatement =
	         "SELECT * from APP.books WHERE qty > 0";
	 
	 
	public BookGateway find(int id) {
        BookGateway result = Registry.getBook(id);
	      if (result  != null) 
	    	  return result;
	      PreparedStatement findStatement = null;
	      ResultSet rs = null;
	      try {
	         findStatement = DBConnection.prepare(findStatementString);
	         findStatement.setInt(1, id);
	         rs = findStatement.executeQuery();
	         rs.next();
	         result = BookGateway.load(rs);
	          
	      } catch (SQLException e) {
	      }
	      return result;
	   }


    public List<BookGateway> findAvailableBooks() {
	      List<BookGateway> result = new ArrayList<>();
	      try {

		        PreparedStatement stmt = DBConnection.prepare(findAvaliableBooksStatement);
	
	        	 ResultSet rs = stmt.executeQuery();
		         while (rs.next()) {
		        	 System.out.println(rs.getInt(1));
			         int id =  rs.getInt(1);
			         String titleArg = rs.getString(2);
			         String authorArg = rs.getString(3);
			         int priceArg = rs.getInt(4);
			         int qtyArg = rs.getInt(5);
			         result.add( new BookGateway(id, titleArg, authorArg, priceArg,qtyArg));
		         }
		         
//	         while (rs.next()) {
//	            result.add(BookGateway.load(rs));
//	         }
	      } catch (SQLException e) {
	      
	      }
	      return result;
	   }

}
