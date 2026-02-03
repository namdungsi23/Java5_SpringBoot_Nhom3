package poly.edu.ASSM.Services.core;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poly.edu.ASSM.Entitty.Category;
import poly.edu.ASSM.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repo;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category findById(String id) {
		Optional<Category> opt = repo.findById(id);
        return opt.orElse(null);
	}

	@Override
	public Category create(Category category) {
		if (existsByName(category.getName())) {
            return null;
        }
        return repo.save(category);
	}

	@Override
	public Category update(Category category) {
		 if (!repo.existsById(category.getId())) {
	            return null;
	        }
	        return repo.save(category);
	}

	@Override
	public void delete(String id) {
		 if (canDelete(id)) {
	            repo.deleteById(id);
	        }
	}

	@Override
	public boolean existsByName(String name) {
		 return repo.existsByName(name);
	}

	@Override
	public boolean canDelete(String id) {
		 Category category = findById(id);
	        if (category == null) {
	            return false;
	        }
	        // không cho xóa nếu còn product
	        return category.getProducts() == null || category.getProducts().isEmpty();
	    }

	@Override
	public Page<Category> search(String keyword, Pageable pageable) {
		 if (keyword == null || keyword.trim().isEmpty()) {
		        return repo.findAll(pageable);
		    }
		    return repo.findByNameContainingIgnoreCase(keyword, pageable);
	}

	@Override
	public long countProductsByCategory(String categoryId) {
		// TODO Auto-generated method stub
	 return repo.countProductsByCategoryId(categoryId);
	}
	}

  

   

