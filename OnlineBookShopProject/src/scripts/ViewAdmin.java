package scripts;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Admin;
import domain.Employee;
import domain.Time;
import domain.TimeSheet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class TimeSheet
 */
@WebServlet("/TimeSheet")
public class ViewAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		TimeSheet timeSheet = null;
		List<Employee> employees = new ArrayList<Employee>();
		
		
		
     
        try {
			employees = Admin.getUsers();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
			timeSheet = Admin.getAllTimes(employees);
		} catch (SQLException e2) {

			e2.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View TimeSheet</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");

		out.print("<h1>View TimeSheet</h1>");

		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>ID</th><th>StartTime</th><th>FinishTime</th><th>Date</th>");
		for(int i= 0 ; i<timeSheet.getIDs().size(); i++) {
				out.print("<tr><td>" + timeSheet.getIDs(i) + "</td><td>" + timeSheet.getFirstNames(i) +  "</td><td>" + timeSheet.getLastNames(i)+ "</td>"
						+ "<td>" + timeSheet.getStartTimes(i) + "</td><td>" + timeSheet.getFinishTimes(i)
						+ "</td><td>" + timeSheet.getDates(i) + "</td>");
		}
				out.println("</form>");
		out.println("</table>");
		out.println("</div>");


//		Displaying users:
		out.print("<h1>View Users</h1>");

		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>ID</th><th>FirstName</th><th>LastName</th>");
		for (Employee e : employees) {
			out.print("<tr><td>" + e.getID() + "</td><td>" + e.getFirstName() + "</td><td>" + e.getLastName()
					+ "</td>");
			out.println("</form>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<a href = 'createTime.html'>CreateTime</a>");
		
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
	
	
	

}