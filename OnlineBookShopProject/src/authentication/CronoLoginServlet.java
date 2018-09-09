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

/**
 * Servlet implementation class CronoLogin
 */
@WebServlet("/CronoLogin")
public class CronoLoginServlet extends HttpServlet {
	
	
	private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/crono;create=true";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Hola from Post method in LoginServlet");
		String user = request.getParameter("userName");
		String pass = request.getParameter("passWord");

			
		
		try {
			PreparedStatement stmt = DBConnection.prepare("SELECT id " +
			         "  from APP.employees " +
			         "  WHERE username ='"+user+"' AND password ='"+pass+"'");
			ResultSet rs = stmt.executeQuery();
			rs.next();			
			int id = rs.getInt(1);
			PrintWriter writer = response.getWriter();
			writer.println("<h3> Hola from Post: Your user name is: "+user+  " , Your password is:    " +pass+ " Your id is:    " + id+"</h3>");

	          } catch (SQLException e){
	              e.printStackTrace();
	              PrintWriter writer = response.getWriter();
	              writer.println("<h3> WRONG WRONG WRONG </h3>");
	          } 

		/*
		String correctUser = getServletConfig().getInitParameter("userNameI");
		String correctPass = getServletConfig().getInitParameter("passWordI");
		PrintWriter writer = response.getWriter();

		if(user.equals(correctUser) && pass.equals(correctPass)) {
			writer.println("<h3> Hello from Post: Your user name is: "+user+  " , Your password is:    " +pass+ "</h3>");
			response.sendRedirect("success.jsp");
		}else {
			writer.println("<h3> Hello from Post: Your user name is: "+user+  " , Your password is:    " +pass+ "</h3>");
			writer.println("<h3> Error </h3>");
		}*/

	}

}
