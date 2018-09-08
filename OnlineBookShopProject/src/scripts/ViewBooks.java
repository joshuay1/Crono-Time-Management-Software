package scripts;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ViewBooks
 */
@WebServlet("/books")
public class ViewBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		List<Book> books = new ArrayList<Book>();
		//books = Persistence.getAllBooks();
        books = Book.getAllAvailableBooks();
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Books</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");

		out.print("<h1>View Books</h1>");

		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>ISBN</th><th>Title</th><th>Author</th><th>price</th><th>Add to Cart</th>");
		for (Book book : books) {
			out.println("<form action=\"cart\" method=\"post\">");
			out.print("<tr><td>" + book.getIsbn() + "</td><td>" + book.getTitle() + "</td><td>" + book.getAuthor()
					+ "</td><td>" + book.getPrice() + "</td>"
					+ "<td colspan=\"2\" align=\"center\"><button type=\"submit\" name=\"isbn\" value=\""
					+ book.getIsbn() + "\" class=\"btn btn-default\">Add to Cart</button></td></tr>");
			out.println("</form>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
