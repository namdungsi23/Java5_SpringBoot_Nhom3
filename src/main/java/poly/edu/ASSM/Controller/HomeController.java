package poly.edu.ASSM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.ASSM.Entitty.Accounts;
import poly.edu.ASSM.Entitty.Category;
import poly.edu.ASSM.Entitty.Product;
import poly.edu.ASSM.Services.core.CategoryServiceImpl;
import poly.edu.ASSM.Services.core.ProductServiceImpl;
import poly.edu.ASSM.Services.util.AuthServiceImpl;
import poly.edu.ASSM.Services.util.ShoppingCartServiceImpl;


@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	ShoppingCartServiceImpl cartService;
	
	@Autowired 
	AuthServiceImpl authService;
	
	@Autowired
	ProductServiceImpl productService;
	
	@Autowired
	CategoryServiceImpl catService;
	
	@ModelAttribute("user")
    public Accounts user() {
        return authService.getUser();
    }
	
	@ModelAttribute("count")
	public int cart() {
        return cartService.getCount();
    }
	
	@GetMapping
	public String index(Model model) {
	    return "layouts/main-content";
	}
	
	@GetMapping("/home")
	public String home() {
	    return "page/index";
	}
	
	@GetMapping("/product")
    public String products(
            @RequestParam(required = false) String cat,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Double min,
            @RequestParam(required = false) Double max,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "price") String sort,
            @RequestParam(defaultValue = "asc") String dir,
            Model model
    ) {
		Sort.Direction direction = 
				dir.equalsIgnoreCase("asc")
					? Sort.Direction.ASC
				    : Sort.Direction.DESC;
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sort));
		
		Page<Product> products = productService.filterProducts(cat, keyword, min, max, pageable);
		
		List<Category> categories = catService.findAll();
		
		model.addAttribute("categories", categories);
		model.addAttribute("products", products);
        model.addAttribute("cat", cat);
        model.addAttribute("keyword", keyword);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("sort", sort);
        model.addAttribute("dir", dir);

        return "page/product";
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
	public String cart(Model model){
		model.addAttribute("cartItems", cartService.getItems());
		model.addAttribute("amount", cartService.getAmount());
		
		return "page/cart/cart";
	}
	@GetMapping("/login")
	public String login(Model model){
		
		return "fragments/header";
	}
	
	@GetMapping("/logout")
	public String logout(Model model){
		cartService.clear();
		authService.logout();
		return "redirect:/";
	}
	@GetMapping("/register")
	public String register(){
		return "page/register";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("cartItems", cartService.getItems());
	    model.addAttribute("amount", cartService.getAmount());
		return "/page/cart/checkout";
	}
	
}
