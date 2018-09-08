package scripts;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Employee;
import domain.Time;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class TimeSheet
 */
@WebServlet("/TimeSheet")
public class ViewTimeSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		List<Time> times = new ArrayList<Time>();
		
        times = Employee.getTimeSheet();
		
		
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
		out.print("<tr><th>ISBN</th><th>StartTime</th><th>FinishTime</th><th>Date</th>");
		for (Time time : times) {
			out.println("<form action=\"cart\" method=\"post\">");
			out.print("<tr><td>" + time.getIsbn() + "</td><td>" + time.getStartTime() + "</td><td>" + time.getFinishTime()
					+ "</td><td>" + time.getDate() + "</td>");
			out.println("</form>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}