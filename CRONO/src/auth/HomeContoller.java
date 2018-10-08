package auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import auth.AppSession;
import domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/home")
public class HomeContoller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/views/index.jsp";
		if (AppSession.isAuthenticated()) {
			try {
				if (User.getUser(AppSession.getUser()).getRole().equals("Employee")) {
					view = "/views/employeeHome.jsp";
				} else if (User.getUser(AppSession.getUser()).getRole().equals("Admin")) {
					view = "/views/adminHome.jsp";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);
		// With most of Shiro, you'll always want to make sure you're working with the
		// currently
		// executing user, referred to as the subject -> will be hidden by AppSession
		// class
		Subject currentUser = SecurityUtils.getSubject();
		String view = "/views/index.jsp";

		try {
			// Authenticate the subject by passing the user name and password token into the
			// login method
			currentUser.login(token);
			// TODO set the user object

			User user = User.getUser(username);

			AppSession.init(user);
			if (AppSession.isAuthenticated()) {
				if (User.getUser(AppSession.getUser()).getRole().equals("Employee")) {
					System.out.println("imEmployee");
					view = "/views/employeeHome.jsp";
				} else if (User.getUser(AppSession.getUser()).getRole().equals("Admin")) {
					view = "/views/adminHome.jsp";
					System.out.println("imAdmin");
				}
			} else {

				view = "/views/index.jsp";

			}

		} catch (UnknownAccountException | IncorrectCredentialsException | SQLException e) {
			// username wasn't in the system or incorrect password
			view = "/views/login-error.jsp";
		} finally {
			ServletContext servletContext = getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
			requestDispatcher.forward(request, response);
		}
	}
}

/*
 * 
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * 
 * 
 * ServletContext servletContext = getServletContext(); int role =
 * Integer.parseInt(request.getParameter("Role")); String view =
 * "/views/index.jsp"; if(role == 1) { view = "/views/employeeHome.jsp"; } else
 * if(role == 0) { view = "/views/adminHome.jsp"; } RequestDispatcher
 * requestDispatcher = servletContext.getRequestDispatcher(view);
 * requestDispatcher.forward(request, response);
 * 
 * }
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * ServletContext servletContext = getServletContext(); String view =
 * "/views/index.jsp"; RequestDispatcher requestDispatcher =
 * servletContext.getRequestDispatcher(view); requestDispatcher.forward(request,
 * response);
 * 
 * 
 * }
 * 
 * 
 * 
 * }
 * 
 */