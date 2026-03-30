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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
		
		if (account == null) {
		    throw new UsernameNotFoundException("User not found");
		}
		
		List<GrantedAuthority> authorities = account
		        .getUserRoles()
		        .stream()
		        .map(ur ->ur.getRole().getName().toUpperCase())
		        .map(role -> (GrantedAuthority) new SimpleGrantedAuthority(role))
		        .toList();
		
		return new User(account.getUsername(), account.getPassword(), authorities);
	}
}

