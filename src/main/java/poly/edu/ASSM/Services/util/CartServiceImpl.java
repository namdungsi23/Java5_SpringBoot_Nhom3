package poly.edu.ASSM.Services.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.edu.ASSM.Entitty.Product;
import poly.edu.ASSM.Services.core.ProductService;
import poly.edu.ASSM.Services.web.SessionService;

@Service
public class CartServiceImpl implements CartService {

	
	@Autowired
	ProductService productService;
	@Autowired
	SessionService sessionService;
	static final String CART_KEY = "cart";
	//Lấy cart từ Session
	Map<Integer, Product> getCart() {
        Map<Integer, Product> cart = sessionService.getAttribute(CART_KEY);
        if (cart == null) {
            cart = new HashMap<>();
            sessionService.setAttribute(CART_KEY, cart);
        }
        return cart;
    }
	@Override
	
	public void add(Integer productId) {
		Map<Integer, Product> cart = getCart();
        Product product = cart.get(productId);

        if (product == null) {
            product = productService.findById(productId);
            product.setQuantity(1);   
            cart.put(productId, product);
        } else {
            product.setQuantity(product.getQuantity() + 1);
        }
	}

	@Override
	public void remove(Integer productId) {
		 getCart().remove(productId);
	}

	@Override
	public void update(Integer productId, int quantity) {
		Product product = getCart().get(productId);
        if (product != null) {
            product.setQuantity(quantity);
        }
	}

	@Override
	public void clear() {
		 getCart().clear();
	}

	@Override
	public Collection<Product> getItems() {
		 return getCart().values();
	}

	@Override
	public int getCount() {
		 return getCart().values()
	                .stream()
	                .mapToInt(Product::getQuantity)
	                .sum();
	}

	@Override
	public double getAmount() {
		return getCart().values()
                .stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }
}
