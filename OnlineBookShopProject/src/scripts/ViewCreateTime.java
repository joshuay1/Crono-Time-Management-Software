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

import domain.Admin;
import domain.Employee;

@WebServlet("/createTime")
public class ViewCreateTime extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Employee> employees = new ArrayList<Employee>();
    	response.setContentType("text.html; charset=UFT-8");
    	int ID = Integer.parseInt(request.getParameter("ID"));
        String startTime = request.getParameter("startTime1");
        String finishTime = request.getParameter("finishTime1");
        String date = request.getParameter("date1");
        
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
		out.println("<h2>The Details entered by the user<h2>");
		out.println("<h3>ID : "+ID+ "<h3>");
		out.println("<h3>Date : "+date+ "<h3>");
		out.println("<h3>startTime : "+startTime+ "<h3>");
		out.println("<h3>finishTime : "+finishTime+ "<h3>");
		
		
	     
        try {
			employees = Admin.getUsers();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			for(Employee e: employees) {
				if(e.getID() == ID) {
					e.instertTime(ID, startTime, finishTime, date);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.println("<a href = 'TimeSheet'> View all times </a>");
		out.println("</body>");
		out.println("</html>");
		
		
    }
    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	response.setContentType("text.html; charset=UFT-8");
//        String startTime = request.getParameter("startTime");
//        String finishTime = request.getParameter("finishTime");
//        
//        response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>View TimeSheet</title>");
//		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
//		out.println("<link rel='stylesheet' href='style.css'/>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h2>The Details entered by the user<h2>");
//		out.println("<h3>startTime : "+startTime+ "<h3>");
//		out.println("<h3>startTime : "+finishTime+ "<h3>");
//		out.println("</body>");
//		out.println("</html>");
//    }

}
