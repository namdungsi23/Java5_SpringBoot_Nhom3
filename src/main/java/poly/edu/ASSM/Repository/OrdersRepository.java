package poly.edu.ASSM.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.edu.ASSM.Entitty.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	// Lấy đơn hàng theo username
    List<Orders> findByAccountUsername(String username);

    // Lấy đơn hàng theo ngày
    List<Orders> findByCreateDate(LocalDate date);

    // Lấy đơn hàng trong khoảng ngày
    List<Orders> findByCreateDateBetween(LocalDate from, LocalDate to);
}
