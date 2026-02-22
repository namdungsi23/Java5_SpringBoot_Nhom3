package poly.edu.ASSM.Services.core;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService extends UserDetails {
	UserDetails LoadUserByUsername(String username);
}
