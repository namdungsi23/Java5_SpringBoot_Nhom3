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
        return repo.loadByUsername(username);
    }

    @Override
    public Accounts update(Accounts acc) {

        Accounts exist = repo.findById(acc.getUsername()).orElse(null);

      
        if (exist == null) {
        	Accounts newAcc = new Accounts();
        	newAcc.setUsername(acc.getUsername());
        	newAcc.setEmail(acc.getEmail());
        	newAcc.setFullname(acc.getFullname());
        	newAcc.setPassword(acc.getPassword()); //Needs hashing - to be done
        	newAcc.setPhoto(acc.getPhoto()); // To be done
        	newAcc.setActivated(true);
        	newAcc.setAdmin(false);
        	newAcc.setUserRoles(null); //To be done
        	return newAcc;
        }

     
        exist.setFullname(acc.getFullname());
        exist.setEmail(acc.getEmail());
        exist.setPhoto(acc.getPhoto());
        exist.setActivated(acc.getActivated());

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