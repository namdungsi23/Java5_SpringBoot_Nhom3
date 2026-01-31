package poly.edu.ASSM.Entitty;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;
	    private String image;
	    private Double price;

	    @Column(name = "createdate")
		LocalDate createDate = LocalDate.now();

	    private Boolean available;
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "CategoryId")
	    private Category category;
	    @Transient
	    private int quantity = 1;

}
