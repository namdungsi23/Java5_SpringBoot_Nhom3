package poly.edu.ASSM.Services.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.edu.ASSM.Entitty.Accounts;
import poly.edu.ASSM.Repository.AccountRepository;

@Service
public class AccountsServiceImpl implements AccountService {

	@Autowired
	AccountRepository repo;
	@Override
	public List<Accounts> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Accounts findByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.findById(username).orElse(null);
	}

	@Override
	public Accounts create(Accounts account) {
		if (repo.existsByUsername(account.getUsername())) {
            throw new RuntimeException("Username đã tồn tại");
        }
        return repo.save(account);
	}

	@Override
	public Accounts update(Accounts account) {
		// TODO Auto-generated method stub
		 return repo.save(account);
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		 repo.deleteById(username);
	}

	@Override
	public boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.existsByUsername(username);
	}

	@Override
	public Accounts login(String username, String password) {
		 Accounts acc = repo.findById(username).orElse(null);

	        if (acc == null) return null;
	        if (!acc.getActivated()) return null;

	        // ❗ Chưa mã hóa mật khẩu (phù hợp ASSM)
	        if (acc.getPassword().equals(password)) {
	            return acc;
	        }
	        return null;
	    }
	}


