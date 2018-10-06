package scripts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Employee;
import domain.Roster;
import domain.Time;

@WebServlet("/times")
public class ViewEmployeeTimes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text.html; charset=UFT-8");
     
    	int ID = Integer.parseInt(request.getParameter("ID"));
    	Employee e = null;
    	try {
			e = Roster.getEmployee(ID);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	List<Time> times = null;
		try {
			times = e.getTimeSheet();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + e.getFirstName() + "'s TimeSheet </title>");
		out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.print("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" + 
				"  <a class=\"navbar-brand\" href=\"#\">CRONO</a>\n" + 
				"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" + 
				"    <span class=\"navbar-toggler-icon\"></span>\n" + 
				"  </button>\n" + 
				"  <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n" + 
				"    <ul class=\"navbar-nav\">\n" + 
				"      <li class=\"nav-item active\">\n" + 
				"        <a class=\"nav-link\" href=\"home?ID="+ID+"\">Home <span class=\"sr-only\">(current)</span></a>\n" + 
				"      </li>\n" + 
				"      <li class=\"nav-item\">\n" + 
				"        <a class=\"nav-link\" href=\'createTime.html'>Clock in</a>\n" + 
				"      </li>\n" + 
				"      <li class=\"nav-item\">\n" + 
				"        <a class=\"nav-link\" href=\'times?ID="+ID+"'>View Time</a>\n" + 
				"      </li>\n" + 
				"    </ul>\n" + 
				"  </div>\n" + 
				"</nav>");
		out.println("<div class='container'>");

		out.print("<h1>Welcome " + e.getFirstName() + "</h1>");
		out.print("<h2>To your TimeSheet</h2>");
		try {
			out.print("<p>You have "+ e.getNumberTimes() + "<p>");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


    	
    	
    	
 
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>StartTime</th><th>FinishTime</th><th>Date</th><th>Payment for work (will convert for feature 2)</th></tr>");
    	for(int i= 0 ; i<times.size(); i++) {
    		try {
				out.println("<tr><td>" + times.get(i).getStartTime() + "</td><td>" + times.get(i).getFinishTime()
						+ "</td><td>" + times.get(i).getDate() + "</td><td>"+times.get(i).getPay()+"</tr>");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    
		out.println("</table>");
		out.println("</div>");
		out.println("<a href = 'createTime.html'>CreateTime</a>");
		
		out.println("</body>");
		out.println("</html>");

		out.close();
		
		
    }
    


}