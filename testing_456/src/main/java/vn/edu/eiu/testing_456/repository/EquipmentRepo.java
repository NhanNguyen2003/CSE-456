package vn.edu.eiu.testing_456.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.eiu.testing_456.model.Equipment;

import java.util.List;


public interface EquipmentRepo extends JpaRepository<Equipment, String> {
    @Query("SELECT e FROM Equipment e WHERE e.quantityAvailable IN " +
            "(SELECT MAX(eq.quantityAvailable) FROM Equipment eq GROUP BY eq.equipmentType)")
    List<Equipment> findTop3ByType();
}
