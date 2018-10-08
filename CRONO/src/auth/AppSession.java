package auth;

import domain.User;
import org.apache.shiro.SecurityUtils;

public class AppSession {

    public static final String USER_ATTRIBUTE_NAME = "user";
    public static final String EMPLOYEE_ROLE = "employee";
    public static final String ADMIN_ROLE = "admin";

    public static boolean hasRole(String role) {
        return SecurityUtils.getSubject().hasRole(role);
    }

    public static boolean isAuthenticated() {
        return SecurityUtils.getSubject().isAuthenticated();
    }
    
    public static boolean isPermitted(String perms) {
        return SecurityUtils.getSubject().isPermitted(perms);
    }

    public static void init(User user) {
        SecurityUtils.getSubject().getSession().setAttribute(USER_ATTRIBUTE_NAME, user.getUserName());
    }

    public static String getUser() {
        return (String) SecurityUtils.getSubject().getSession().getAttribute(USER_ATTRIBUTE_NAME);
    }

}

