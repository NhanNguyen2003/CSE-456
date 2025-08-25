package vn.edu.eiu.testing_456.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Equipment")
public class Equipment {
    @Id
    @Column(name = "equipmentId", length = 10)
    private String equipmentId;

    @ManyToOne
    @JoinColumn(name = "equipmentTypeId", nullable = false)
    private EquipmentType equipmentTypeId;

    @Column(name = "equipmentName", length = 150, nullable = false)
    @Size(min = 5, max = 100)
    private String equipmentName;

    @Column(name = "purchasePrice", precision = 10, scale = 2, nullable = false)
    @DecimalMin(value = "1000")
    private BigDecimal purchasePrice;

    @Column(name = "quantityAvailable", nullable = false)
    @Min(value = 0)
    @Max(value = 500)
    private int quantityAvailable;

    @Column(name = "purchaseDate", nullable = false, updatable = false)
    private LocalDateTime purchaseDate = LocalDateTime.now();

}
