package poly.edu.ASSM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.ASSM.Entitty.Accounts;
import poly.edu.ASSM.Services.core.AccountService;
import poly.edu.ASSM.Services.util.AuthService;

@Controller
public class AuthController {
	@Autowired
	AuthService auth;
	@Autowired
	AccountService Account;

	@GetMapping("/auth")
	public String authPage() {
		return "page/login";

	}

	@PostMapping("/login")
	public String login(Model model, @RequestParam String username, @RequestParam String password) {
		Accounts user = auth.login(username, password);
		if (user == null) {
			model.addAttribute("error", "Sai tên tài khoản và mật khẩu!");
			model.addAttribute("showRegister", false);
			return "page/login";
		}
		if (auth.isAdmin()) {
			return "redirect:/admin";
		}
		return "redirect:/";
	}

	/* ==Xử lý Register== */
	@PostMapping("/register")
	public String register(@RequestParam String username, @RequestParam String email, @RequestParam String password,
			@RequestParam String confirm, Model model) {
		if (Account.existsByUsername(username)) {
			model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
			model.addAttribute("showRegister", true);
			return "page/login";

		}
		if (!password.equals(confirm)) {
			model.addAttribute("error", "Mật khẩu không khớp!");
			model.addAttribute("showRegister", true);
			return "page/login";
		}
		// Tạo tài khoản
		Accounts acc = new Accounts();
		acc.setUsername(username);
		acc.setPassword(password);
		acc.setEmail(email);
		acc.setActivated(true);
		acc.setAdmin(true);
		Account.save(acc);
		model.addAttribute("sucess", "Đăng nhập thành công!Hãy đăng nhập");
		model.addAttribute("showRegister", false);
		return "page/login";
		// Logout

	}

	@GetMapping("/logout")
	public String logout() {
		auth.logout();
		return "redirect:/auth";
	}
}
