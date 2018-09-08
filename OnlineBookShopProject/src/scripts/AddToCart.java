package scripts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.Persistence;
import bookshop.User;
import domain.Book;
import domain.ShoppingCart;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/cart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
  


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String bookISBN = request.getParameter("isbn");
        System.out.println(bookISBN);
        ShoppingCart cart = User.getCustomer().getCart();
        Book book = Persistence.getBook(bookISBN);
        cart.addBook(book);
        User.getCustomer().setCart(cart);
      
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Added to cart</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");

        if(book == null) {
            out.println("Sorry the book is not avaliable anymore!");
            response.sendRedirect("books");

        }
        else {
        	out.println("Book is added successfully!");
        	Persistence.removeBook(bookISBN);
        }

        out.println("</div>");
        
        
        out.println("<div class='container'>");
        out.print("<form action=\"ViewCart\" method=\"post\">");
        out.print("<button type=\"submit\" name=\"bookInCart\" value=\"" +
        		bookISBN +  " class=\"btn btn-default\">Checkout</button>");
        out.print("</form>");
        out.println("</div>");

        out.println("<a href=\"books\">back to book list</a>");

        out.println("</body>");
        out.println("</html>");

        
        
        out.close();

    }

	

}
