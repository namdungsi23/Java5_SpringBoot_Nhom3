package poly.edu.ASSM.Services.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import poly.edu.ASSM.Entity.Accounts;
import poly.edu.ASSM.Repository.AccountRepository;

@Service
public class AccountsServiceImpl implements AccountService {

    @Autowired
    AccountRepository repo;

    @Override
    public List<Accounts> findAll() {
        return repo.findAll();
    }

    @Override
    public Page<Accounts> findAll(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }

    @Override
    public Accounts findByUsername(String username) {
        return repo.findById(username).orElse(null);
    }

    @Override
    public Accounts update(Accounts acc) {

        Accounts exist = repo.findById(acc.getUsername()).orElse(null);

      
        if (exist == null) return null;

     
        exist.setFullname(acc.getFullname());
        exist.setEmail(acc.getEmail());
        exist.setPhoto(acc.getPhoto());
        exist.setActivated(acc.getActivated());

        // ❌ TUYỆT ĐỐI KHÔNG ĐỘNG
        // admin
        // superAdmin
        // password

        return repo.save(exist); 
    }

    @Override
    public void delete(String username) {
        repo.deleteById(username);
    }

    @Override
    public Accounts login(String username, String password) {

        Accounts acc = repo.findById(username).orElse(null);

        if (acc == null) return null;

      
        if (!acc.getActivated()) return null;

  
        if (!acc.getPassword().equals(password)) return null;

        return acc;
    }

    @Override
    public Page<Accounts> search(String keyword, int page, int size) {
        return repo.search(keyword, PageRequest.of(page, size));
    }

    
    
}