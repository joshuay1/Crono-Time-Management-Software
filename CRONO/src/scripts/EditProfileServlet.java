package scripts;

import java.io.IOException;
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

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    	response.setContentType("text.html; charset=UFT-8");
	    	int ID = Integer.parseInt(request.getParameter("ID"));
	        String email = request.getParameter("email");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastname");
	        
	        try {
				Roster.updateProfile(ID, firstName, lastName, email, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        
	        response.sendRedirect("home?ID=" +ID);
	    }

}
