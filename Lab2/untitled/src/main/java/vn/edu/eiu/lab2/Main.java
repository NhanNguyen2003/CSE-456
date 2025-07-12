package vn.edu.eiu.lab2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.eiu.lab2.entity.Student;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");

    public static void main(String[] args) {
        // gọi hàm insertStudent
        //  insertStudent();
        //  getStudentbyId();
        // getAllStudent();
        // updateStudentById("CSE2025003", "Nguyen Tan Nhan456", 8.0, 2005);
        // deleteStudentById("CSE2025003");
        // getAllStudent();


    }

    // Định nghĩa các hàm CRUD
    public static void insertStudent() {
        // B1. Gọi người quản lý việc tương tác database
        EntityManager em = emf.createEntityManager();

        // B2. Chuẩn bị data đê insert
        Student student1 = new Student("CSE2025001", "Nguyen Tan Nhan", 4.1, 2001);
        Student student2 = new Student("CSE2025002", "Nguyen Tan Nhan1", 4.2, 2002);
        Student student3 = new Student("CSE2025003", "Nguyen Tan Nhan2", 4.3, 2003);


        // B3. Người quản lý thực hiện việc insert
        // Khi thực thi các câu lệnh sql dạng DML (Data Manipulation Language: có làm thay đổi dữ liệu thì bắt buộc
        // phải đặt trong 1 transaction để đảm bảo tính ACID: Amoty Consistency Isolation Durability: Một là thực thi
        // câu lệnh từ đầu đến cuối, còn ngược lại thì ko làm gì cả, rollback

        em.getTransaction().begin();
        em.persist(student1); // Ghi xuống database nhưng chưa thực hiện ghi
        em.persist(student2);
        em.persist(student3);
        em.getTransaction().commit(); // Đã ghi xuống database
        em.close(); // cho anh quản lý nghỉ việc


    }

    public static void getStudentbyId() {
        EntityManager em = emf.createEntityManager();
        Student student1 = em.find(Student.class, "CSE2025001");

        if (student1 != null) {
            System.out.println("Student found: " + student1.toString());
        } else {
            System.out.println("Student not found");
        }

    }

    public static void getAllStudent() {
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("select s from Student s", Student.class).getResultList();

        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            System.out.println("List of students found: ");
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }

    }

    public static void updateStudentById(String id, String newname, double newgpa, int newyob) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Student student = em.find(Student.class, id);

        if (student != null) {
            student.setName(newname);
            student.setGpa(newgpa);
            student.setYob(newyob);

            em.merge(student);
            em.getTransaction().commit();

            System.out.println("Student updated with ID: " + id);

        } else {
            System.out.println("Student not found");
            em.getTransaction().rollback();
        }
        em.close();


    }

    public static void deleteStudentById(String id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
            System.out.println("Student deleted with ID: " + id);
        } else  {
            System.out.println("Student not found");
        }
        em.close();
    }


}