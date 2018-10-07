package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concurrency.LockManager;
import domain.Roster;
import sesh.Session;

/**
 * Servlet implementation class AdminViewEmployeesController
 */
@WebServlet("/ViewEmployees")
public class AdminViewEmployeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewEmployeesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
    	String view = "/views/viewEmployees.jsp";
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creating new user
//		Session session = Session.refreshSession(request.getSession(),"admin");
		
//		try {
//			
//			//LockManager.getInstance().acquireWriteLock(session.getUser("admin"));
//		}
//		catch(InterruptedException e) {
//			System.out.println("Acquiring Write lock when admin editing user");
//		}
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String role = request.getParameter("Role");
        try {
			Roster.createUser(firstName, lastName, email, username, password1, role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        LockManager.getInstance().releaseWriteLock(session.getUser("admin"));
        
        ServletContext servletContext = getServletContext();
        String view = "/views/viewEmployees.jsp";
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
        
	}

}
