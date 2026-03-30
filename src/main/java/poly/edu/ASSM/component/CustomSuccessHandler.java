package poly.edu.ASSM.component;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import poly.edu.ASSM.Entity.Accounts;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		 //  LƯU VÀO SESSION
        HttpSession session = request.getSession();
        session.setAttribute("USER_SESSION", authentication.getPrincipal());
        System.out.println(session.getAttribute("USER_SESSION"));
		
		for(GrantedAuthority authority : authorities) {
			if(authority.getAuthority().equals("ROLE_ADMIN")) { 
				response.sendRedirect("/admin");
				return;
			}
		}
		
		response.sendRedirect("/product");
		
	}

}
