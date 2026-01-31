package poly.edu.ASSM.Entitty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private Double price;
	    private Integer quantity;

	    @ManyToOne
	    @JoinColumn(name = "OrderId")
	    private Orders order;

	    @ManyToOne
	    @JoinColumn(name = "ProductId")
	    private Product product;
}
