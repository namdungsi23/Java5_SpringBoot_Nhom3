package poly.edu.ASSM.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.edu.ASSM.Entitty.OrderDetails;

@Repository
public interface OrderDetailsRepository  extends JpaRepository<OrderDetails, Integer>{
	List<OrderDetails> findByOrderId(int orderId);

    // Lấy chi tiết theo Product
    List<OrderDetails> findByProductId(int productId);

    // Tính tổng số lượng theo Order
    Integer countByOrderId(int orderId);

    // Xóa tất cả chi tiết theo Order
    void deleteByOrderId(int orderId);
}
