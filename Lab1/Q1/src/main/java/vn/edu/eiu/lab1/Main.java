package vn.edu.eiu.lab1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.edu.eiu.lab1.entity.Course;
import vn.edu.eiu.lab1.entity.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Student student1 = new Student("STD1", "Nguyen", "Nhan", 2003, 3.2);
        Student student2 = new Student("STD2", "Nguyen", "Nhan1", 2004, 3.3);
        Student student3 = new Student("STD3", "Nguyen", "Nhan2", 2005, 3.4);

        Course course = new Course("CSE 456", "Advanced Java Programming", 4, 60);
        Course course1 = new Course();
        course1.setIdCourse("CSE 301");
        course1.setName("Introduction to Database");
        course1.setCredits(4);
        course1.setHours(60);

//        System.out.println("The list of Students: ");
//        System.out.println("Student 1: " + student1.toString());
//        System.out.println("Student 2: " + student2.toString());
//        System.out.println("Student 3: " + student3.toString());
//        System.out.println("The list of Courses: ");
//        System.out.println("Course 1: " + course1.toString());
//        System.out.println("Course 2: " + course1.toString());

        // Java Object to Json
        ObjectMapper mapper = new ObjectMapper();
        String jstudent1 = mapper.writeValueAsString(student1);

//        System.out.println("Student dang JSON: "+ jstudent1);

        String jsonTOobject = "{\"id\":\"STD4\",\"firstName\":\"Nguyen\",\"lastName\":\"Nhan\",\"yearOfBirth\":2006,\"gpa\":3.2}";
        Student student4 = mapper.readValue(jsonTOobject, Student.class);
        System.out.println("Student dang Object: "+ student4.toString());


    }
}
