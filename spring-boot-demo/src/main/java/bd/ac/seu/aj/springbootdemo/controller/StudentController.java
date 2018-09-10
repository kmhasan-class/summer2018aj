package bd.ac.seu.aj.springbootdemo.controller;

import bd.ac.seu.aj.springbootdemo.exception.ResourceDoesNotExistException;
import bd.ac.seu.aj.springbootdemo.model.Student;
import bd.ac.seu.aj.springbootdemo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "student")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping(value = "all")
    @ResponseBody
    // CW: modify this method so that it returns a ResponseEntity
    // return the list of students only if the role is Admin or Officer
    // otherwise return a status code Unauthorized
    public List<Student> getAllStudents() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Student> studentList = new ArrayList<>();
        studentService.getStudents().forEach(studentList::add);
        return studentList;
    }

    @GetMapping(value = "{id}")
    @ResponseBody
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        System.out.println("GET request for ID " + id);
        Optional<Student> optionalStudent = studentService.getStudent(id);

        if (optionalStudent.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(optionalStudent.get());
        else throw new ResourceDoesNotExistException("Student not found");
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
