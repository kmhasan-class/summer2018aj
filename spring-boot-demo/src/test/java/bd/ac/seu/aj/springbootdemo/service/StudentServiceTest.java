package bd.ac.seu.aj.springbootdemo.service;

import bd.ac.seu.aj.springbootdemo.exception.ResourceAlreadyExistsException;
import bd.ac.seu.aj.springbootdemo.model.Student;
import bd.ac.seu.aj.springbootdemo.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class StudentServiceTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Before
    public void deleteStudents() {
        studentRepository.deleteAll();
    }

    @Test
    public void testCreateStudent() {
        /*
        Student student = new Student(4345, "Test Student", 2.53);
        Student savedStudent = studentService.createStudent(student);
        Assert.assertEquals(student.getId(), savedStudent.getId());
        Assert.assertEquals(student.getName(), savedStudent.getName());
        Assert.assertEquals(student.getCgpa(), savedStudent.getCgpa(), 1E-5);
        */
    }

    @Test
    public void testCreateDuplicateStudent() {
        /*
        Student student = new Student(4345, "Test Student", 2.53);
        Student savedStudent = studentService.createStudent(student);

        expectedException.expect(ResourceAlreadyExistsException.class);
        student = new Student(4345, "Someone new", 2.511);

        savedStudent = studentService.createStudent(student);
        */
    }

    // Task
    // implement the other test methods (get all students, get a specific student etc.)
}
