package poly.edu.ASSM.component;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import poly.edu.ASSM.Entity.Accounts;
import poly.edu.ASSM.Services.core.AccountsServiceImpl;

@Component
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
	AccountsServiceImpl accountService;
	
	@Override 
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws IOException, ServletException {
		OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
		
		//OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
		OAuth2User oauth2User = token.getPrincipal();
		
		// Lấy info từ Google
        String email = oauth2User.getAttribute("email");
        //String email = oidcUser.getEmail();
        String name = oauth2User.getAttribute("name");
        String picture = oauth2User.getAttribute("picture");
        
        Accounts user = accountService.findByUsername(email);

        if (user == null) {
            user = new Accounts();
            user.setUsername(email);
            user.setEmail(email);
            user.setFullname(name);
            user.setPhoto(picture);
            user.setActivated(true);
            user.setAdmin(false);
            user.setPassword("");

            accountService.update(user);
        }

        //  LƯU VÀO SESSION
        HttpSession session = request.getSession();
        session.setAttribute("USER_SESSION", user);
        System.out.println(((Accounts)session.getAttribute("USER_SESSION")).getEmail());

        //Redirect
        response.sendRedirect("/");
    }
		
}


