package poly.edu.ASSM.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.ASSM.Entity.Inventory;
import poly.edu.ASSM.Entity.Product;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	Optional<Inventory> findByProduct(Product product);

}
