package vn.edu.eiu.lab2;


import vn.edu.eiu.lab2.DAO.GenericDAO;
import vn.edu.eiu.lab2.entity.Gender;
import vn.edu.eiu.lab2.entity.Major;
import vn.edu.eiu.lab2.entity.School;
import vn.edu.eiu.lab2.entity.Student;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        GenericDAO<School> schoolDao = new GenericDAO<>(School.class);
        GenericDAO<Major> majorDao = new GenericDAO<>(Major.class);
        GenericDAO<Student> studentDao = new GenericDAO<>(Student.class);

        // Add School
        School school = new School("EIU1", "EIU", "Block B11");
        schoolDao.create(school);

        // Add Major
        Major major = new Major();
        major.setMajorId("CIT");
        major.setMajorName("Software Engineering");
        major.setSchool(school);
        majorDao.create(major);

        // Add Student
        Student student = new Student();
        student.setFullName("Nguyen Tan Nhan");
        student.setGender(Gender.Male);
        student.setDob(new GregorianCalendar(2003, Calendar.DECEMBER, 25).getTime());
        student.setGpa(3.5);
        student.setEnrollmentYear(2026);
        student.setSchool(school);
        student.setMajor(major);
        studentDao.create(student);

        System.out.println("All students:");
        studentDao.getAll().forEach(s -> System.out.println(s.getFullName()));
    }
}
