package auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            currentUser.logout();
        }

        response.sendRedirect("/CRONO/home");
    }
}
