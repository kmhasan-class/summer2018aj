package bd.ac.seu.aj.springbootdemo.service;

import bd.ac.seu.aj.springbootdemo.exception.ResourceAlreadyExistsException;
import bd.ac.seu.aj.springbootdemo.exception.ResourceDoesNotExistException;
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

    public Student createStudent(Student student) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (optionalStudent.isPresent()) {
            throw new ResourceAlreadyExistsException("Student with ID " + student.getId() + " already exists");
        } else {
            return studentRepository.save(student);
        }
    }

    public Student updateStudent(long studentId, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            student.setId(studentId);
            return studentRepository.save(student);
        } else {
            throw new ResourceDoesNotExistException("Student with ID " + studentId + " does not exist");
        }
    }

    /*
    existing student
    studentId: 11
    studentName: "John Doe"
    cgpa: 3.98

    update student
    id: 11

    studentId: 11
    studentName: "John Doe"
    cgpa: 3.95
     */
}
