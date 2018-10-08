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

import auth.AppSession;
import domain.Employee;
import domain.Roster;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/views/index.jsp";
		if (AppSession.isAuthenticated()) {
			if (AppSession.isPermitted("admin:view_time")) {
				System.out.println("Permitted");
				view = "/views/adminProfileEditor.jsp";
			} else {
				view = "/home";
			}
		} else {
			view = "/home";
		}

		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		if (AppSession.isAuthenticated()) {
			if (AppSession.isPermitted("admin:edit_user")) {
				System.out.println("Permitted");

				if (type == 1) {// deleting user

					int id = Integer.parseInt(request.getParameter("ID"));

					Roster.deleteUser(id);

					response.sendRedirect("/CRONO/ViewEmployees");
				} else if (type == 2) { // paying

					int timeID = Integer.parseInt(request.getParameter("ID"));
					int userID = Integer.parseInt(request.getParameter("userID"));
					Employee.payTime(timeID);
					response.sendRedirect("/CRONO/adminEdit?ID=" + userID);

				} else if (type == 3) { // updating user
					int ID = Integer.parseInt(request.getParameter("ID"));
					String email = request.getParameter("email");
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					String firstName = request.getParameter("firstName");
					String lastName = request.getParameter("lastName");

					try {
						Roster.updateProfile(ID, firstName, lastName, email, username, password);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//			LockManager.getInstance().releaseWriteLock(session.getUser("admin"));
					response.sendRedirect("/CRONO/ViewEmployees");
				}
			} else {
				response.sendRedirect("/CRONO/home");
			}
		} else {
			response.sendRedirect("/CRONO/home");
		}

	}

}
