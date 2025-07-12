package vn.edu.eiu.lab2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Lecturer")
public class Lecturer {
    @Id // đánh dấu cột khóa chính
    @Column(name = "ID", nullable = false)
    private BigInteger id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    String name;

    @Column(name = "Year Of Birth", nullable = false)
    private int yob;

    @Column(name = "Salary", nullable = false)
    private double salary;

}
