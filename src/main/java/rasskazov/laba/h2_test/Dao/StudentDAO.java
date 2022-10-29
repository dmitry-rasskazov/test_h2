package rasskazov.laba.h2_test.Dao;

import org.springframework.stereotype.Repository;
import rasskazov.laba.h2_test.Entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();

    Student getStudent(int id);

    Student saveStudent(Student student);

    void deleteStudent(int id);
}