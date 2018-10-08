package sesh;

import domain.Employee;
import domain.User;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public class Session {

    private static final String USER_ATTRIBUTE_NAME = "user";

    private HttpSession httpSession;

    private Session(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public static Session refreshSession(HttpSession httpSession, String username) throws SQLException {
        if (httpSession.getAttribute(username) == null) {
            User user = User.getUser(username);
            httpSession.setAttribute(username, user);
            httpSession.setMaxInactiveInterval(24 * 60 * 60);
        }
        return new Session(httpSession);
    }

    public User getUser(String username) {
        return (User) httpSession.getAttribute(username);
    }

}
