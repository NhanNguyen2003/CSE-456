package vn.edu.eiu.practice_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.practice_final.model.Student;
import vn.edu.eiu.practice_final.repository.StudentRepo;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    // hàm lưu sinh viên xuống db
    public void saveStudent(Student student) {studentRepo.save(student);}

    // hàm lấy tất cả sinh viên (phục vụ cho trang student-list)
    public List<Student> getAllStudents(){ return studentRepo.findAll();}

    // hàm lâấy sinh viên bằng id phục vụ cho viên edit trên view
    public Student getStudentById(String id){return studentRepo.findById(id).orElseThrow();} // hàm tự sinh

    // hàm phục vụ xóa sinh viên
    public void removeStudentById(String id){studentRepo.deleteById(id);}

    // hàm phục vụ tìm kiếm sinh viên bằng tên
    public List<Student> searchStudentsByName(String keyword) {
        return studentRepo.searchAllByNameContainingIgnoreCase(keyword);
    }

    // hàm phục vụ kiểm trang trùng pk
    public Boolean checkExistById(String id){return studentRepo.existsById(id);} // hàm tự sinh
}
