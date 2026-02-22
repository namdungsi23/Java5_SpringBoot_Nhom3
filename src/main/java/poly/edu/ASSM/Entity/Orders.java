package poly.edu.ASSM.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createdate")
    private LocalDate createDate = LocalDate.now();

    @Column(name = "address", columnDefinition = "NVARCHAR(255)")
    private String address;

    @Column(name = "status")
    private String status; // NEW, CONFIRMED, SHIPPED, DONE, CANCELLED

    @Column(name = "total_amount")
    private Double totalAmount;

    // ====== USER ĐẶT ĐƠN ======
    @ManyToOne
    @JoinColumn(name = "Username")
    private Accounts account;

    // ====== CHI TIẾT ĐƠN HÀNG ======
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;
}
