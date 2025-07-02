package bdbt_project.SpringApplication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class RedirectService {

    public static String getRedirectPath(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();

            if (hasRole(authorities, "ROLE_ADMIN")) {
                return "admin";
            } else if (hasRole(authorities, "ROLE_USER")) {
                return "user";
            }
        }

        return "/";
    }

    private static boolean hasRole(List<GrantedAuthority> authorities, String targetRole) {
        return authorities.stream().anyMatch(role -> role.getAuthority().equals(targetRole));
    }
}