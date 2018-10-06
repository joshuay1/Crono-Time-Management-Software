package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Employee;
import domain.Roster;

@WebServlet("/createTime")
public class CreateTimeContoller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	response.setContentType("text.html; charset=UFT-8");
    	int ID = Integer.parseInt(request.getParameter("ID"));
        String startTime = request.getParameter("startTime1");
        String finishTime = request.getParameter("finishTime1");
        String date = request.getParameter("date1");
        System.out.print("id "+ ID + ", startTIme "+startTime +", finishTime "+finishTime+", date "+date);

		
		
	     
        try {
			Employee e = Roster.getEmployee(ID);
			e.instertTime(ID, startTime, finishTime, date,0);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        
        response.sendRedirect("/CRONO/home");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ServletContext servletContext = getServletContext();
    	String view = "/views/createTime.jsp";
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
		
		
    }

}
