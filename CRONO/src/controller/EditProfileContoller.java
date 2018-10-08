package controller;

import java.io.IOException;
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

import auth.AppSession;
import domain.Employee;
import domain.Roster;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/editProfile")
public class EditProfileContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	    	response.setContentType("text.html; charset=UFT-8");
		if (AppSession.isAuthenticated()) {
			if (AppSession.isPermitted("employee:edit_profile")) {
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

				response.sendRedirect("home?ID");
			} else {
				response.sendRedirect("/CRONO/home");
			}
		} else {
			response.sendRedirect("/CRONO/home");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		String view = "/views/editProfile.jsp";
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
		requestDispatcher.forward(request, response);

	}

}
