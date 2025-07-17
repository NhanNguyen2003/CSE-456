package vn.edu.eiu.lab2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "majorId", columnDefinition = "CHAR(4)")
    private String majorId;

    @Column(name = "majorName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String majorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolId", referencedColumnName = "schoolId", nullable = false)
    private School school;
}
