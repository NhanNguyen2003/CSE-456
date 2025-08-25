package vn.edu.eiu.practice_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.eiu.practice_final.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User searchByUsernameIgnoreCase(String username);
}
