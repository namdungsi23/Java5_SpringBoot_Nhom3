package poly.edu.ASSM.Services.core;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import poly.edu.ASSM.Entitty.Category;

public interface CategoryService {

    // CRUD
    List<Category> findAll();
    Category findById(String id);
    Category create(Category category);
    Category update(Category category);
    void delete(String id);

    // Business
    boolean existsByName(String name);
    boolean canDelete(String id);
    Page<Category> search(String keyword, Pageable pageable);
    long countProductsByCategory(String categoryId);



}
