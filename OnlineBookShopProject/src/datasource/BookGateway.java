package datasource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookGateway {
	private int id;
	 private String  title;
	 private String  author;
	 private float  price;
     private int qty;
	 private static final String updateStatementString =
	         "UPDATE APP.books " +
                     "  set title = ?, author = ?, price = ?, qty = ? " +
                     "  where isbn = ?";
	
	 private static final String insertStatementString =
	         "INSERT INTO APP.books VALUES (?, ?, ?, ?, ?)";


    public BookGateway(int id, String title, String author, float price, int qty) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
        this.qty = qty;
    }

	public BookGateway() {
	}

    public int getqty() {
        return qty;
    }

    public void setqty(int qty) {
        this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
   public void update() {
      PreparedStatement updateStatement = null;
      try {
         updateStatement = DBConnection.prepare(updateStatementString);
         updateStatement.setString(1, title);
         updateStatement.setString(2, author);
         updateStatement.setFloat(3, price);
          updateStatement.setInt(4, qty);
         updateStatement.setInt(5, id);

         updateStatement.execute();
      } catch (Exception e) {
    
      }
   }
		  
   public int insert() {
      PreparedStatement insertStatement = null;
      try {
         insertStatement = DBConnection.prepare(insertStatementString);
         insertStatement.setInt(1,id);
         insertStatement.setString(2, title);
         insertStatement.setString(3, author);
         insertStatement.setFloat(4, price);
          insertStatement.setInt(5, qty);

         insertStatement.execute();
         Registry.addBook(this);
      } catch (SQLException e) {
      }
      return getId();

   }

    public static BookGateway load(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        BookGateway result = Registry.getBook(id);
        if (result != null)
            return result;
        String titleArg = rs.getString(2);
        String authorArg = rs.getString(3);
        int priceArg = rs.getInt(4);
        int qtyArg = rs.getInt(5);
        result = new BookGateway(id, titleArg, authorArg, priceArg, qtyArg);
        Registry.addBook(result);
        return result;
    }
}
