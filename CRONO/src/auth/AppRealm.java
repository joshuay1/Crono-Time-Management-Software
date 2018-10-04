package auth;

import domain.Employee;
import domain.Admin;
import domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class AppRealm extends JdbcRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // identify account to log to
        UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
        final String username = userPassToken.getUsername();

        final User user = User.getUser(username);
        if (user == null) {
            System.out.println("No account found for user with username " + username);
            return null;
        }

        return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), getName());
    }

    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        Set<String> roles = new HashSet<>();
        Set<Permission> perms = new HashSet<Permission>();
        if (principals.isEmpty()) {
            System.out.println("Given principals to authorize are empty.");
            return null;
        }

        int username = (Integer) principals.getPrimaryPrincipal();
        final User user = User.getUser(username);

        if (user == null) {
            System.out.println("No account found for user with username " + username);
            return null;
        }

        // add roles of the user according to its type
        if (user instanceof Employee) {
            roles.add(AppSession.EMPLOYEE_ROLE);
        } else if (user instanceof Admin) {
            roles.add(AppSession.ADMIN_ROLE);
        }
        
        for (Permission permission : role.getPermissions()) {
            perms.add(permission);
        }

        return new SimpleAuthorizationInfo(roles);
    }
}
