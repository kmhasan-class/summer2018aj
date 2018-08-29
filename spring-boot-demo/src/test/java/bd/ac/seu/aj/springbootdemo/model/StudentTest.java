package bd.ac.seu.aj.springbootdemo.model;

import bd.ac.seu.aj.springbootdemo.exception.InvalidRangeException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class StudentTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAllArgsConstructor() {
        Student student = new Student(4225, "John Doe", 3.23);
        Assert.assertEquals(4225, student.getId());
        Assert.assertEquals("John Doe", student.getName());
        Assert.assertEquals(3.23, student.getCgpa(), 0.0001);
    }

    // assuming that we decided that the IDs are going to be
    // four digit numbers
    @Test
    public void testIdRangeUnderflow() {
        Student student = new Student(1234, "John Doe", 3.21);
        Assert.assertEquals(1234, student.getId());

        //expectedException.expect(InvalidRangeException.class);
        student = new Student(123, "John Doe", 3.21);
    }

    @Test
    public void testIdRangeOverflow() {
        Student student = new Student(1234, "John Doe", 3.21);
        Assert.assertEquals(1234, student.getId());

        //expectedException.expect(InvalidRangeException.class);
        student = new Student(12345, "John Doe", 3.21);
    }

    @Test
    @Ignore
    public void testCgpaRange() {

    }
}
