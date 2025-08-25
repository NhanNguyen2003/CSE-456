package vn.edu.eiu.practice_final.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_Student")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Student {

    @Id
    @Column(name = "ID", columnDefinition = "CHAR(5)")
    private String id;

    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(100)")
    private String name;

    @Column(name = "Year of Birth", nullable = false)
    private int yob;

    @Column(name = "GPA")
    private double gpa;

    @ManyToOne()
    @JoinColumn(name = "MajporID")
    private Major major;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }
}
