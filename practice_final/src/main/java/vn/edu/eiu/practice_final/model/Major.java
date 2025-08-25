package vn.edu.eiu.practice_final.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_Major")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "major")
    private List<Student> studentList = new ArrayList<>();

    // nếu id tự tăng thì phải tự thêm 1 constructor và bỏ id đi
    public Major(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // thêm sinh viên cho major
    public void addStudent(Student student) {
        studentList.add(student);
        student.setMajor(this);
    }

    // xóa sinh viên ra khỏi major
    public void removeStudent(Student student) {
        studentList.remove(student);
        student.setMajor(null);
    }
}
