package vn.edu.eiu.testing_456.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.testing_456.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);

}
