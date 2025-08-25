package vn.edu.eiu.practice_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.practice_final.model.User;
import vn.edu.eiu.practice_final.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // hàm phục vụ lưu user
    public void save(User user){ userRepo.save(user);}

    // hàm phục vụ login
    public User findByUsername(String username){ return userRepo.searchByUsernameIgnoreCase(username);}
}
