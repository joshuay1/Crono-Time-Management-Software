package auth;

import domain.Employee;
import domain.Admin;
import domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AppRealm extends JdbcRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // identify account to log to
        UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
        final String username = userPassToken.getUsername();
        System.out.println(username);

        User user;
		try {
			user = User.getUser(username);
		} catch (SQLException e) {
			System.out.println("No account found for user with username " + username);
			e.printStackTrace();
			 return null;
		}
 

        return new SimpleAuthenticationInfo(user.getID(), user.getPassword(), getName());
    }

    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        // Set<String> roles = new HashSet<>();
        // Set<String> perms = new HashSet<>();
        if (principals.isEmpty()) {
            System.out.println("Given principals to authorize are empty.");
            return null;
        }

        int username = (Integer) principals.getPrimaryPrincipal();
        User user;
		try {
			user = User.getUser(username);
		} catch (SQLException e) {
			System.out.println("No account found for user with username " + username);
			e.printStackTrace();
			return null;
		}


        // add roles of the user according to its type
        // Set<String> role = new HashSet<>();
        // role.add(user.getRole());
		System.out.println(user.getRole());
        System.out.println(user.getUserPermission(user.getRole()));
        SimpleAuthorizationInfo authinfo = new SimpleAuthorizationInfo();
        authinfo.addStringPermissions(user.getUserPermission(user.getRole()));
       
       

        return authinfo;
    }
}
