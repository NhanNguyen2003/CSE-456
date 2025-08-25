package vn.edu.eiu.practice_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.practice_final.model.Major;

@Repository
public interface MajorRepo extends JpaRepository<Major, Long> {

}
