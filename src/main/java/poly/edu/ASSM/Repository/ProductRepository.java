package poly.edu.ASSM.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.edu.ASSM.Entitty.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
