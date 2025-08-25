package vn.edu.eiu.practice_final.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.practice_final.model.Major;
import vn.edu.eiu.practice_final.model.Student;
import vn.edu.eiu.practice_final.model.User;
import vn.edu.eiu.practice_final.service.MajorService;
import vn.edu.eiu.practice_final.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentServ;

    @Autowired
    private MajorService majorServ;

    @GetMapping("students")
    public String students(@RequestParam(value = "keyword", defaultValue = "")
                               String keyword, Model model, HttpSession ses){
        User user = (User) ses.getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        List<Student> studentList = new ArrayList<>();
        if(keyword.isBlank()) {
            studentList = studentServ.getAllStudents();
        } else {
            studentList = studentServ.searchStudentsByName(keyword);
        }

        model.addAttribute("studentList", studentList);

        return "student-list";
    }

    @GetMapping("student/edit/{id}")
    public String editStudent(@PathVariable("id") String id,
                              Model model, HttpSession ses, RedirectAttributes RedAttr){
        User user = (User) ses.getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        if(user.getRole() !=1 && user.getRole() !=2){
            RedAttr.addFlashAttribute("errRole","Access Denied. You are not allowed to perform this action.");
            return "redirect:/students";
        }
        // lấy sinh viên từ db c mã là id
        Student s = studentServ.getStudentById(id);

        // gửi qua cho form chỉnh sửa
        model.addAttribute("student", s);

        // gửi thêm danh sách major để làm select (comboBox)
        List<Major> majorList = majorServ.getAllMajor();
        model.addAttribute("majorList", majorList);

        // gửi kèm 1 attribute để báo là edit student
        model.addAttribute("formMode", "edit");

        return "student-form";
    }
    //Hàm xử lí link thêm mới sinh viên
    @GetMapping("/student/add")
    public String addStudent(Model model, HttpSession ses, RedirectAttributes RedAttr) {
        //Không cho gõ link trực tiếp, chưa login > login
        User user = (User) ses.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        //Login rồi > Kiểm tra thêm role không phải là 1 và 2
        if(user.getRole() != 1) {
            //báo lỗi access denied.
            RedAttr.addFlashAttribute("errRole", "Access Denied. You are not allowed to perform this action.");
            return "redirect:/students";
        }
        //Lấy toàn bộ major để gửi qua comboBox(select) của form
        //Note: attributeName phải giống với hàm edit
        List<Major> majorList = majorServ.getAllMajor();
        model.addAttribute("majorList", majorList);

        //Tạo mới và gửi một sinh viên chưa có thông tin để gửi qua form
        //Note: attributeName phải giống với hàm edit
        model.addAttribute("student", new Student());

        //Gửi kèm một attribute để báo là thêm student
        model.addAttribute("formMode","add");
        return "student-form";
    }

    //Hàm xử lý cho url /student/form, khi người dùng bấm save trên form bằng Post method
    @PostMapping("/student/form")
    public String saveStudent(@Valid @ModelAttribute("student") Student s, BindingResult result, Model model, @RequestParam("formMode") String formMode, HttpSession ses, RedirectAttributes RedAttr) {

        //Lấy thông tin gửi từ form xuống, Nếu có lỗi thì sẽ quay lại trang form, kèm theo các message
        if(result.hasErrors()){
            model.addAttribute("formMode",formMode);
            model.addAttribute("majorList", majorServ.getAllMajor());

            return "student-form";
        }

        /*Nếu thêm mới mà trùng key thì báo lỗi và trả lại trang form kèm lỗi:
         * Lấy key đem dò trong db xem đã có hay chưa (cần service?)
         * Nếu có thì quay lại form gửi kèm thông báo trùng key.*/
        if(formMode.equals("add")){
            if(studentServ.checkExistById(s.getId())){
                model.addAttribute("formMode",formMode);
                model.addAttribute("majorList", majorServ.getAllMajor());
                model.addAttribute("duplicateId","Id is already exists");
                return "student-form";
            }
        }

        //Nếu data ok hết thì lưu sinh viên và chuyển qua trang students
        studentServ.saveStudent(s);
        //Validate coi thông tin có hợp lệ không
        //Lưu xuống database
        //Trả về url students để hiển thị danh sách sinh viên đã cập nhật bằng redirect
        return "redirect:/students";
    }

    //Hàm xử lý link xóa môt sinh viên /student/delete
    @GetMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id, HttpSession ses, RedirectAttributes RedAttr) {
        //Không cho gõ link trực tiếp, chưa login > login
        User user = (User) ses.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        //Login rồi > Kiểm tra thêm role không phải là 1 và 2
        if(user.getRole() != 1) {
            //báo lỗi access denied.
            RedAttr.addFlashAttribute("errRole", "Access Denied. You are not allowed to perform this action.");
            return "redirect:/students";
        }
        //Gọi service hực hiện xóa sinh viên
        studentServ.removeStudentById(id);
        //Trả về trang student
        return "redirect:/students";
    }
}
