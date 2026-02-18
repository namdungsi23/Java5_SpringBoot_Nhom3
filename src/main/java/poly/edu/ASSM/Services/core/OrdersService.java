package poly.edu.ASSM.Services.core;

import java.time.LocalDate;
import java.util.List;

import poly.edu.ASSM.Entity.Orders;

public interface OrdersService {
	 // CRUD
    List<Orders> findAll();
    Orders findById(int id);
    Orders create(Orders order);
    Orders update(Orders order);
    void delete(int id);

    // Business
    List<Orders> findByUsername(String username);
    List<Orders> findByDate(LocalDate date);
    List<Orders> findByDateRange(LocalDate from, LocalDate to);

    // Admin nghiệp vụ
    Orders updateStatus(int orderId, String status);
    long countTodayOrders();
}
