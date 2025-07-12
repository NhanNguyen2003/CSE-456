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
@Table(name = "Subject")
public class Subject {
    @Id // đánh dấu cột khóa chính
    @Column(name = "Code", columnDefinition = "CHAR(10)", nullable = false)
    private String code;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(25)", nullable = false)
    private String description;

    @Column(name = "Credit", nullable = false)
    private int credit;

    @Column(name = "Study Hours", nullable = false)
    private int studyHours;

}

