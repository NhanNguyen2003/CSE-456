package vn.edu.eiu.practice_final.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String password;

    @Column(nullable = false)
    private int role;

    // tự tạo constructor đầy đủ tham số (trừ id vì id tự tặng)
    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
