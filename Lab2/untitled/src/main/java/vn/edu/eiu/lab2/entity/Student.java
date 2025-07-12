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
@Table(name = "Students")
public class Student {
    @Id // đánh dấu cột khóa chính
    @Column(name = "ID", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    String name;

    @Column(name = "GPA", nullable = false)
    private double gpa;

    @Column(name = "Year Of Birth", nullable = false)
    private int yob;

}
