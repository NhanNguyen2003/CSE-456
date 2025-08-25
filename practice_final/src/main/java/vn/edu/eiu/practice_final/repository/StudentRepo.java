package vn.edu.eiu.practice_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.practice_final.model.Student;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
    List<Student> searchAllByNameContainingIgnoreCase(String name);
}
