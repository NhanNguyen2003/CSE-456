package vn.edu.eiu.testing_456.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "EquipmentType")
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "equipmentTypeId")
    private int equipmentTypeId;

    @Column(name = "typeName", length = 100, nullable = false, unique = true)
    private String typeName;

    @Column(name = "description")
    private String description;

}
