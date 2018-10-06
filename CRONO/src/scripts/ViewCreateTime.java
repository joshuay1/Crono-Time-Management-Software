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

@WebServlet("/createTime")
public class ViewCreateTime extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	response.setContentType("text.html; charset=UFT-8");
    	int ID = Integer.parseInt(request.getParameter("ID"));
        String startTime = request.getParameter("startTime1");
        String finishTime = request.getParameter("finishTime1");
        String date = request.getParameter("date1");

		
		
	     
        try {
			Employee e = Roster.getEmployee(ID);
			e.instertTime(ID, startTime, finishTime, date);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        
        response.sendRedirect("home?ID=" +ID);
    }

}
