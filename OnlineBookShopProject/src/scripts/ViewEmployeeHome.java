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

@WebServlet("/home")
public class ViewEmployeeHome extends HttpServlet {

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
		out.print("<h2>To your HomePage</h2>");


    	
    	

		out.println("</div>");
		out.println("<a href = 'createTime.html'>CreateTime</a>");
		
		out.println("</body>");
		out.println("</html>");

		out.close();
		
		
    }
    


}