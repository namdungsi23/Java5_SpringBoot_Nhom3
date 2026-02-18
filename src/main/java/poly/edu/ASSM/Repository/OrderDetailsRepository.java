package poly.edu.ASSM.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import poly.edu.ASSM.Entity.OrderDetails;

@Repository
public interface OrderDetailsRepository  extends JpaRepository<OrderDetails, Integer>{
	List<OrderDetails> findByOrder_Id(Integer orderId);

    // Chi tiết theo sản phẩm
    List<OrderDetails> findByProduct_Id(Integer productId);

    // Tổng số lượng sản phẩm trong đơn
    @Query("""
        SELECT SUM(od.quantity)
        FROM OrderDetails od
        WHERE od.order.id = :orderId
    """)
    Integer sumQuantityByOrder(@Param("orderId") Integer orderId);

    // Xóa chi tiết theo đơn
    void deleteByOrder_Id(Integer orderId);
}
