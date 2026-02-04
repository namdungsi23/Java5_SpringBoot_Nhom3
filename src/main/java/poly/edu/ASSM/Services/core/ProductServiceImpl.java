package poly.edu.ASSM.Services.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.edu.ASSM.Entitty.Product;
import poly.edu.ASSM.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	  @Autowired
	   ProductRepository repo;
	  
	    // ===== CRUD cơ bản =====
	    @Override
	    public List<Product> findAll() {
	        return repo.findAll();
	    }

	    @Override
	    public Product findById(Integer id) {
	        return repo.findById(id).orElse(null);
	    }

	    @Override
	    public Product create(Product product) {
	        return repo.save(product);
	    }

	    @Override
	    public Product update(Product product) {
	        return repo.save(product);
	    }

	    @Override
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }

	@Override
	public Page<Product> findAll(int page, int size, String sortBy, String sortDir, String keyword) {
		// TODO Auto-generated method stub
		Sort sort = sortDir.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        // Có keyword → tìm theo tên
        if (keyword != null && !keyword.trim().isEmpty()) {
            return repo.findByNameContainingIgnoreCase(keyword, pageable);
        }

        // Không keyword → lấy tất cả
        return repo.findAll(pageable);
    }

		@Override
		public Page<Product> filterProducts(String cat, String keyword, Double min, Double max, Pageable pageable) {
			return repo.filterProducts(cat, keyword, min, max, pageable);
		}
	}


