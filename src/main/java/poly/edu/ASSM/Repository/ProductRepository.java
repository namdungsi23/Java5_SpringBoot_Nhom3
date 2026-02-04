package poly.edu.ASSM.Repository;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import poly.edu.ASSM.Entitty.Category;
import poly.edu.ASSM.Entitty.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
	@Query("""
			SELECT p FROM Product p
			WHERE (:cat IS NULL OR  :cat = '' OR p.category.name = :cat)
			AND (:keyword IS NULL OR :keyword = '' 
				 	OR LOWER(p.name) LIKE LOWER( CONCAT('%',:keyword,'%') ))
			AND (:min IS NULL OR p.price >= :min)
			AND (:max IS NULL OR p.price <= :max)
			""")
	Page<Product> filterProducts(@Param("cat") String cat, 
								@Param("keyword") String keyword, 
								@Param("min") Double min, 
								@Param("max") Double max, 
								Pageable pageable);
}
