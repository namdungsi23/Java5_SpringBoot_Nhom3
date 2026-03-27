package poly.edu.ASSM.Services.core;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import poly.edu.ASSM.Entity.Inventory;
import poly.edu.ASSM.Entity.Product;
import poly.edu.ASSM.Repository.InventoryRepository;
import poly.edu.ASSM.Repository.ProductRepository;
import poly.edu.ASSM.exception.InvalidInputException;

@Service
public class ProductServiceImpl implements ProductService{

	  @Autowired
	   ProductRepository repo;
	  
	  @Autowired
	   InventoryRepository inventoryRepo;
	  
	    // ===== CRUD cơ bản =====
	    @Override
	    public List<Product> findAll() {
	        return repo.findAll();
	    }

	    @Override
	    public Product findById(Integer id) {
	        return repo.findById(id).orElse(null);
	    }
	    
	    @Transactional
	    @Override
	    public Product create(Product formProduct, int quantity) {
	    	
	    	Product dbProduct;

	        // ===== CREATE or UPDATE =====
	        if (formProduct.getId() != null) {
	            dbProduct = repo.findById(formProduct.getId())
	                    .orElseThrow();
	        } else {
	            dbProduct = new Product();
	        }

	        dbProduct.setName(formProduct.getName());
	        dbProduct.setPrice(formProduct.getPrice());
	        dbProduct.setCategory(formProduct.getCategory());
	        dbProduct.setAvailable(formProduct.getAvailable());
	        dbProduct.setDescription(formProduct.getDescription());
	        
	        /*
		        Inventory dbInv =
		            inventoryRepo.findByProduct(dbProduct).orElse(null);
	        */
	        
         	Inventory dbInv = dbProduct.getInventory();

	        if (dbInv == null) {
	            dbInv = new Inventory();
	            dbInv.setProduct(dbProduct);
	        }
	        
	        if(quantity <= 0) {
            	throw new InvalidInputException("Số lượng phải lớn hơn 0!");
            }

	        dbInv.setQuantity(quantity);
	        dbInv.setLastUpdated(LocalDateTime.now());

	        dbProduct.setInventory(dbInv);

	        return repo.save(dbProduct);
	    }

	    @Override
	    public Product update(Product product) {
	    	Inventory inv = product.getInventory();

	    	if (inv != null) {
	    	    inv.setProduct(product); // set owning side
	    	}
	    	
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

		@Override
		public Product create(Product product) {
			// TODO Auto-generated method stub
			return null;
		}
	}


