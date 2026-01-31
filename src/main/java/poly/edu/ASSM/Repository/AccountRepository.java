package poly.edu.ASSM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.edu.ASSM.Entitty.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, String> {
	 boolean existsByUsername(String username);

	    Accounts findByUsernameAndPassword(String username, String password);
}
