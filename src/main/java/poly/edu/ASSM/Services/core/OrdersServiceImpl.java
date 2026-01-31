package poly.edu.ASSM.Services.core;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.edu.ASSM.Entitty.Orders;
import poly.edu.ASSM.Repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository repo;
	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Orders findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Orders create(Orders order) {
		// TODO Auto-generated method stub
		return repo.save(order);
	}

	@Override
	public Orders update(Orders order) {
		// TODO Auto-generated method stub
		return repo.save(order);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Orders> findByUsername(String username) {
		return repo.findByAccountUsername(username);
	}

	@Override
	public List<Orders> findByDate(LocalDate date) {
		// TODO Auto-generated method stub
		 return repo.findByCreateDate(date);
	}

	@Override
	public List<Orders> findByDateRange(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return repo.findByCreateDateBetween(from, to);
	}

}
