package poly.edu.ASSM.Services.core;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import poly.edu.ASSM.Entitty.Product;

public interface ProductService {
	List<Product> findAll();

    Product findById(Integer id);

    Product create(Product product);

    Product update(Product product);

    void delete(Integer id);
    
    Page<Product> findAll(
            int page,
            int size,
            String sortBy,
            String sortDir,
            String keyword
    );
    
    Page<Product> filterProducts(String cat, String keyword, Double min, Double max, Pageable pageable);
}
