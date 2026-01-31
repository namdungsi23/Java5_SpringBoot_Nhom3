package poly.edu.ASSM.Services.util;

import java.util.Collection;

import poly.edu.ASSM.Entitty.Product;

public interface CartService {
	 void add(Integer productId);

	    void remove(Integer productId);

	    void update(Integer productId, int quantity);

	    void clear();

	    Collection<Product> getItems();

	    int getCount();

	    double getAmount();
}
