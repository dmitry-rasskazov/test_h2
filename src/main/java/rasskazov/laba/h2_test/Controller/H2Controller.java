package rasskazov.laba.h2_test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rasskazov.laba.h2_test.Entity.Student;
import rasskazov.laba.h2_test.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class H2Controller {
    private final StudentService studentService;

    @Autowired
    public H2Controller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> showAllStudents()
    {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") Integer id)
    {
        return this.studentService.getStudent(id);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student)
    {
        return this.studentService.saveStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student)
    {
        return this.studentService.saveStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Integer id)
    {
        this.studentService.deleteStudent(id);
    }
}
