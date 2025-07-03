package vn.edu.eiu.lab1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private double gpa;

    public Student(String id, String firstName, String lastName, int yearOfBirth, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.gpa = gpa;
    }


}
