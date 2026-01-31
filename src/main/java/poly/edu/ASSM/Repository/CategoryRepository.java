package poly.edu.ASSM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.edu.ASSM.Entitty.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
