package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datasource.DBConnection;
import datasource.TimeGateway;
import domain.User;

/**
 * Servlet implementation class CronoLogin
 */
@WebServlet("/CronoLogin")
public class CronoLoginServlet extends HttpServlet {
	
	
	private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/CRONO;create=true";
	private static final String USER = "user";
	private static final String PASSWORD = "123";
	private static final long serialVersionUID = 1L;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CronoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Hello from GET method in LoginServlet");
		 String user = request.getParameter("userName");
		 String pass = request.getParameter("passWord");
		
		PrintWriter writer = response.getWriter();
		writer.println("<h3> Hello from Get "+user+  "   " +pass+ "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		System.out.println("Hola from Post method in LoginServlet");
		String user = request.getParameter("userName");
		String pass = request.getParameter("passWord");
		int id = -1;
		try {
			id = User.getID(user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(id != -1) {
			response.sendRedirect("home?ID=" +id);
		}
		else {
			response.sendRedirect("invalidUser.html");
		}

	}

}
