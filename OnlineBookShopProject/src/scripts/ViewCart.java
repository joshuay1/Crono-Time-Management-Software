package scripts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.User;
import domain.Book;
import domain.Order;
import domain.ShoppingCart;

/**
 * Servlet implementation class ViewCart
 */
@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("bookInCart");
		System.out.println(isbn);
	    ShoppingCart cart = User.getCustomer().getCart();

	    
	      Order order = new Order(cart.getBookCopies(),User.getCustomer()) ; 
	      float totalPrice = 0;
	      for (Map.Entry<Book, Integer> entry : cart.getBookCopies().entrySet()) {
	    	  totalPrice = totalPrice + (entry.getKey().getPrice() * entry.getValue());
	      }
	      order.setTotalPrice(totalPrice);
	      
	    	response.setContentType("text/html");
	      
	        PrintWriter out = response.getWriter();
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Shopping Cart</title>");
	        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
	        out.println("<link rel='stylesheet' href='style.css'/>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div class='container'>");

	        out.println("<h1>Invoice</h1>");
	        out.println("<h2>List of books in cart</h2>");

	        out.println("<table class='table table-bordered table-striped'>");
	        out.print("<tr><th>ISBN</th><th>Title</th><th>Author</th><th>Price</th></tr>");
	        for(Book book:cart.getBookCopies().keySet()) {
	        	
	        	 out.print("<tr><td>" + book.getIsbn() + "</td><td>" + book.getTitle() + "</td><td>" + book.getAuthor() +
		                    "</td><td>" + book.getPrice() + "</td></tr>");
	        }
	        out.println("</table>");
	        out.println("</div>");
	        
	        out.println("<div class='container'>");

	        out.println("<table class='table table-bordered table-striped'>");
	        out.println("<tr><th>Ship to: </th><td>"+order.getOrderedBy().getName()+"</td></tr>");
	        out.println("<tr><th>Adress: </th>><td>"+order.getOrderedBy().getAddress()+"</td></tr>");

	        out.print("<tr><th>Total price:  </th> <td> "+ order.getTotalPrice()+"</td></tr>");

	        out.println("</table>");
	        out.println("</div>");
	        out.println("<div class='container'>");

	        out.println("<button  type=\"submit\">Process Payment</button>");
	        out.println("</div>");

	        out.println("</body>");
	        out.println("</html>");

	        out.close();
	        
		
	}

}
