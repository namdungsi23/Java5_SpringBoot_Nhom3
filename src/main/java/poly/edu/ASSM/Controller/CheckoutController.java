package poly.edu.ASSM.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poly.edu.ASSM.Entitty.OrderDetails;
import poly.edu.ASSM.Entitty.Orders;
import poly.edu.ASSM.Services.core.*;
import poly.edu.ASSM.Services.util.AuthServiceImpl;
import poly.edu.ASSM.Services.util.ShoppingCartServiceImpl;
import poly.edu.ASSM.domain.CartItem;
import poly.edu.ASSM.domain.PaymentMethod;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	@Autowired
	ShoppingCartServiceImpl cartService;
	
	@Autowired
	OrdersServiceImpl orderService;
	
	@Autowired
	AccountsServiceImpl accountService;
	
	@Autowired
	AuthServiceImpl authService;
	
	@Autowired
	ShoppingCartServiceImpl cartServcie;
	
	@Autowired
	ProductServiceImpl productService;
	
	@Autowired
	OrderDetailsServiceImpl odService;
	
	@GetMapping("/payment")
	public String paymentView(@RequestParam PaymentMethod paymentMethod,
							  Model model) {
		model.addAttribute("username",authService.getUser().getUsername());
		model.addAttribute("paymentMethod", paymentMethod);
	    model.addAttribute("amount", cartService.getAmount());
	    model.addAttribute("proceeding", true);
		return "page/cart/payment";
	}
	
	@PostMapping("/pay")
	public String proceedPayment(@RequestParam PaymentMethod paymentMethod,
								 RedirectAttributes redirect) {

		redirect.addAttribute("paymentMethod", paymentMethod);
		
		return "redirect:/checkout/payment";
	}
	
	/* Cần chuẩn hóa */
	@Transactional 
	@PostMapping("/confirm")
	public String confirm(@RequestParam String username,
						  @RequestParam String address,  
						  Model model) {
		Orders order = new Orders();
		order.setAddress(address);
		order.setAccount(accountService.findByUsername(username));
		order.setCreateDate(LocalDate.now());
		orderService.create(order);
		
		for(CartItem item : cartService.getItems()) {
			OrderDetails orderDetail = new OrderDetails();
			orderDetail.setOrder(order);
			orderDetail.setProduct(productService.findById(item.getProductId()));
			orderDetail.setPrice(item.getPrice());
			orderDetail.setQuantity(item.getQuantity());
			odService.create(orderDetail);
		}
		
		cartService.clear();
		
		model.addAttribute("success", true);
		model.addAttribute("proceeding", false);
		
		return "page/cart/payment";
	}
}
