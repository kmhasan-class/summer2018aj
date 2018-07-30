package bd.ac.seu.aj.springbootdemo.service;

import bd.ac.seu.aj.springbootdemo.model.Student;
import bd.ac.seu.aj.springbootdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getStudent(long studentId) {
        return studentRepository.findById(studentId);
    }

    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }
}
