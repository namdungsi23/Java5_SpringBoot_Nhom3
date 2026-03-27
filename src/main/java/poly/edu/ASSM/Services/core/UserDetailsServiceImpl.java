package poly.edu.ASSM.Services.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import poly.edu.ASSM.Entity.Accounts;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1674080619095529853L;
	
	@Autowired
	AccountsServiceImpl accService; 

	@Override
	public UserDetails loadUserByUsername(String username) {
		Accounts account = accService.findByUsername(username);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		

		if(account != null) {
			if(account.getAdmin()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}else {
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			}
		}
		
		return new User(account.getUsername(), account.getPassword(), authorities);
	}
}

