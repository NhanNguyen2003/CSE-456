package vn.edu.eiu.lab2.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "School")
public class School {

    @Id
    @Column(name = "schoolId", columnDefinition = "CHAR(4)")
    private String schoolId;

    @Column(name = "schoolName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String schoolName;

    @Column(name = "location", columnDefinition = "NVARCHAR(100)")
    private String location;
}
