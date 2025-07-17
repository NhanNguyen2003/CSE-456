package vn.edu.eiu.lab2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "Full Name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender", nullable = false)
    private Gender gender;

    @Column(name = "Date of Birth", nullable = false)
    private Date dob;

    @Column(name = "GPA")
    private double gpa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "majorId", referencedColumnName = "majorId")
    private Major major;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolId", referencedColumnName = "schoolId", nullable = false)
    private School school;

    @Column(name = "Enrollment Year", nullable = false)
    private int enrollmentYear;



}
