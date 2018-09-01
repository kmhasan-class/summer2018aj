package bd.ac.seu.aj.springbootdemo.controller;

import bd.ac.seu.aj.springbootdemo.model.Student;
import bd.ac.seu.aj.springbootdemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PostMapping
    @ResponseBody
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student createdStudent = studentService.createStudent(student);
            ResponseEntity<Student> studentResponseEntity = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdStudent);
            return  studentResponseEntity;
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping(value = "{studentId}")
    @ResponseBody
    public Student updateStudent(@PathVariable long studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

}
