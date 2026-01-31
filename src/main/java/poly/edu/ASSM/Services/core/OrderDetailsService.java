package poly.edu.ASSM.Services.core;

import java.util.List;

import poly.edu.ASSM.Entitty.OrderDetails;

public interface OrderDetailsService {
	  List<OrderDetails> findAll();
	    OrderDetails findById(int id);
	    OrderDetails create(OrderDetails detail);
	    OrderDetails update(OrderDetails detail);
	    void delete(int id);

	    // Business
	    List<OrderDetails> findByOrder(int orderId);
	    List<OrderDetails> findByProduct(int productId);
	    void deleteByOrder(int orderId);
}
