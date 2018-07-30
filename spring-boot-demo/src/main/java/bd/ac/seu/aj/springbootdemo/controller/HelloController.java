package bd.ac.seu.aj.springbootdemo.controller;

import bd.ac.seu.aj.springbootdemo.model.Student;
import bd.ac.seu.aj.springbootdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "hello")
public class HelloController {
    private StudentRepository studentRepository;

    public HelloController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping(value = "/person")
    @ResponseBody
    public String sayHelloTo(@RequestParam  String name) {
        return "Hello, " + name;
    }

    @GetMapping(value = "/students")
    @ResponseBody
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(value = "/student")
    @ResponseBody
    public Student getStudent(@RequestParam long id) {
        return studentRepository
                .findById(id)
                .get();
                //.orElse(new Student());
    }

    // HW: Modify this method so that it returns all the students
    // for which the name match
    @GetMapping(value = "/student1")
    @ResponseBody
    public Student getStudent(@RequestParam String name) {
        return studentRepository
                .findStudentByName(name);
    }

    // HW: Write a controller method that returns all the students
    // within a CGPA range, for example: [3.00, 3.50]

    // JSON - JavaScript Object Notation

    // BAD DESIGN
    @GetMapping(value = "/createstudent1")
    @ResponseBody
    public Student insertStudent1(@RequestParam long id,
                               @RequestParam String name,
                               @RequestParam double cgpa) {
        Student student = new Student(id, name, cgpa);
        return studentRepository.save(student);
    }

    @PostMapping(value = "/createstudent2")
    @ResponseBody
    public Student insertStudent2(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // HW: try Update and Delete operations on your own

}
