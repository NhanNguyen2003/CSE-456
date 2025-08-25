package vn.edu.eiu.testing_456.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.eiu.testing_456.model.User;
import vn.edu.eiu.testing_456.repository.UserRepo;

public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void save(User user) {
        userRepo.save(user);
    }


}
