package rasskazov.laba.h2_test.Service;

import rasskazov.laba.h2_test.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(Integer id);

    void deleteStudent(Integer id);
}
