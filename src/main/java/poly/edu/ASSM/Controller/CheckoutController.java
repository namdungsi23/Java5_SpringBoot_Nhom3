package poly.edu.ASSM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poly.edu.ASSM.Services.util.ShoppingCartServiceImpl;
import poly.edu.ASSM.domain.PaymentMethod;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	@Autowired
	ShoppingCartServiceImpl cartService;
	
	@GetMapping
	public String checkout(Model model) {
		model.addAttribute("cartItems", cartService.getItems());
	    model.addAttribute("amount", cartService.getAmount());
		return "/page/cart/checkout";
	}
	
	@GetMapping("payment")
	public String paymentView(@RequestParam PaymentMethod paymentMethod,
							  Model model) {
		model.addAttribute("paymentMethod", paymentMethod);
	    model.addAttribute("amount", cartService.getAmount());
		return "page/cart/payment";
	}
	
	@PostMapping("/pay")
	public String proceedPayment(@RequestParam PaymentMethod paymentMethod,
								 RedirectAttributes redirect) {

		redirect.addAttribute("paymentMethod", paymentMethod);
		
		return "redirect:/checkout/payment";
	}
	
	@PostMapping("/confirm")
	public String confirm(@RequestParam String username,
						  @RequestParam String address,  
						  RedirectAttributes redirect) {

		
		return "";
	}
}
