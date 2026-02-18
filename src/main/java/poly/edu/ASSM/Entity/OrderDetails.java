package poly.edu.ASSM.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OrderDetails")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // ====== ĐƠN HÀNG ======
    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Orders order;

    // ====== SẢN PHẨM ======
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    private Double price;

    private Integer quantity;
}
