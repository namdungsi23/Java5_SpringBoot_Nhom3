package poly.edu.ASSM.Services.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.edu.ASSM.Entitty.Category;
import poly.edu.ASSM.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    CategoryRepository repo;
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category findById(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return repo.save(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return repo.save(category);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public boolean existsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
