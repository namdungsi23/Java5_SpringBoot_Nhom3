package poly.edu.ASSM.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import poly.edu.ASSM.Entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	 // Đơn theo user
    List<Orders> findByAccountUsername(String username);

    // Đơn theo ngày
    List<Orders> findByCreateDate(LocalDate date);

    // Đơn theo khoảng ngày
    List<Orders> findByCreateDateBetween(LocalDate from, LocalDate to);

    // Thống kê hôm nay
    @Query("SELECT COUNT(o) FROM Orders o WHERE o.createDate = :today")
    long countTodayOrders(@Param("today") LocalDate today);

    // Thống kê theo trạng thái
    @Query("""
        SELECT COUNT(o)
        FROM Orders o
        WHERE o.createDate = :today
          AND o.status = :status
    """)
    long countTodayOrdersByStatus(
        @Param("today") LocalDate today,
        @Param("status") String status
    );
}
