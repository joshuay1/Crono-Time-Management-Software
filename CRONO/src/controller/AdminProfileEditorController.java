package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concurrency.LockManager;
import domain.Employee;
import domain.Roster;
import sesh.Session;


/**
 * Servlet implementation class AdminProfileEditorController
 */
@WebServlet("/adminEdit")
public class AdminProfileEditorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfileEditorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("ID"));
		response.sendRedirect("/CRONO/views/adminProfileEditor.jsp?ID="+id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
//		Session session = Session.refreshSession(request.getSession(),"admin");
//		
//		try {
//			
//			LockManager.getInstance().acquireWriteLock(session.getUser("admin"));
//		}
//		catch(InterruptedException e) {
//			System.out.println("Acquiring Write lock when admin editing user");
//		}
		
		
		if(type == 1) {//deleting user
			
			
			int id = Integer.parseInt(request.getParameter("ID"));
	
			Roster.deleteUser(id);
	        
	        response.sendRedirect("/CRONO/ViewEmployees");
		}
		else if (type == 2) { //paying
			
			int timeID = Integer.parseInt(request.getParameter("ID"));
			int userID = Integer.parseInt(request.getParameter("userID"));
			Employee.payTime(timeID);
			response.sendRedirect("/CRONO/adminEdit?ID="+userID);
					
		}
		else if (type == 3) {
			int ID = Integer.parseInt(request.getParameter("ID"));
	        String email = request.getParameter("email");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        int role = Integer.parseInt(request.getParameter("Role"));
	        
	        try {
				Roster.updateProfile(ID, firstName, lastName, email, username, password, role);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			LockManager.getInstance().releaseWriteLock(session.getUser("admin"));
	        response.sendRedirect("/CRONO/ViewEmployees");
	        
		}
		
	}

}
