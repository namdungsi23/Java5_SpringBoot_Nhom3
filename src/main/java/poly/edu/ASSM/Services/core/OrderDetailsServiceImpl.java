package poly.edu.ASSM.Services.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.edu.ASSM.Entitty.OrderDetails;
import poly.edu.ASSM.Repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsRepository repo;
	@Override
	public List<OrderDetails> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public OrderDetails findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public OrderDetails create(OrderDetails detail) {
		// TODO Auto-generated method stub
		return repo.save(detail);
	}

	@Override
	public OrderDetails update(OrderDetails detail) {
		// TODO Auto-generated method stub
		return repo.save(detail);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<OrderDetails> findByOrder(int orderId) {
		// TODO Auto-generated method stub
		return repo.findByOrderId(orderId);
	}

	@Override
	public List<OrderDetails> findByProduct(int productId) {
		// TODO Auto-generated method stub
		return repo.findByProductId(productId);
	}

	@Override
	public void deleteByOrder(int orderId) {
		// TODO Auto-generated method stub
	 repo.deleteByOrderId(orderId);
	}

}
