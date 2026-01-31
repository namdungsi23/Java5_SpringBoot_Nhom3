package poly.edu.ASSM.Services.core;

import java.util.List;

import poly.edu.ASSM.Entitty.Accounts;

public interface AccountService {
	List<Accounts> findAll();

    Accounts findByUsername(String username);

    Accounts create(Accounts account);

    Accounts update(Accounts account);

    void delete(String username);

    boolean existsByUsername(String username);

    Accounts login(String username, String password);
}
