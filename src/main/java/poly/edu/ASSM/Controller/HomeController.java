package poly.edu.ASSM.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
	    return "page/index";
	}
	@GetMapping("/contact")
	public String contact(){
		return "page/contact";
	}
	@GetMapping("/more")
	public String more(){
		return "page/more";
	}

	@GetMapping("/cart")
	public String cart(){
		return "page/cart";
	}
	@GetMapping("/login")
	public String login(){
		return "page/login";
	}
	@GetMapping("/register")
	public String register(){
		return "page/register";
	}
}
