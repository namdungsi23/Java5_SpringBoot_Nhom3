package poly.edu.ASSM.Services.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.edu.ASSM.Entitty.Accounts;
import poly.edu.ASSM.Services.core.AccountService;
import poly.edu.ASSM.Services.web.SessionService;

@Service
public class AuthServiceImpl  implements AuthService{
	

	    @Autowired
	    AccountService accountService;

	    @Autowired
	    SessionService sessionService;

	    static final String USER_SESSION = "user";
		@Override
		public Accounts login(String username, String password) {
			Accounts user = accountService.findByUsername(username);

	        if (user == null) {
	            return null;
	        }

	        if (!user.getPassword().equals(password)) {
	            return null;
	        }

	        if (!Boolean.TRUE.equals(user.getActivated())) {
	            return null;
	        }

	        sessionService.setAttribute(USER_SESSION, user);
	        return user;
		}

		@Override
		public void logout() {
			sessionService.removeAttribute(USER_SESSION);
			
		}

		@Override
		public Accounts getUser() {
			 return sessionService.getAttribute(USER_SESSION);
		}

		@Override
		public boolean isLogin() {
			 return getUser() != null;
		}

		@Override
		public boolean isAdmin() {
			Accounts user = getUser();
	        return user != null && Boolean.TRUE.equals(user.getAdmin());
		}

	
	}


