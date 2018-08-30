package bd.ac.seu.aj.springbootdemo.controller;

import bd.ac.seu.aj.springbootdemo.model.Student;
import bd.ac.seu.aj.springbootdemo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "all")
    @ResponseBody
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentService.getStudents().forEach(studentList::add);
        return studentList;
    }

    @GetMapping(value = "{id}")
    @ResponseBody
    public Student getStudent(@PathVariable long id) {
        return studentService.getStudent(id).get();
    }
}
