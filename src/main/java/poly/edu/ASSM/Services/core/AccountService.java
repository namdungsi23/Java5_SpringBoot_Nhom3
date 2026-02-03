package poly.edu.ASSM.Services.core;

import java.util.List;

import org.springframework.data.domain.Page;

import poly.edu.ASSM.Entitty.Accounts;

public interface AccountService {
	List<Accounts> findAll();
	 Page<Accounts> findAll(int page, int size);
    Accounts findByUsername(String username);

    Accounts create(Accounts account);

    Accounts update(Accounts account);

    void delete(String username);

    boolean existsByUsername(String username);

    Accounts login(String username, String password);
    Page<Accounts> search(String keyword, int page, int size);

}
