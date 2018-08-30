package bd.ac.seu.aj.vaadindemo.service;

import bd.ac.seu.aj.vaadindemo.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    private ObjectMapper objectMapper;

    public StudentService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Student> getAllStudents() {
        // HW: instead of working with fake data, make sure that
        // the data is read from a web service
        String message = "";
        Student[] students = null;
        try {
            URL url = new URL("http://172.17.10.2:8080/student/all");
            students = objectMapper.readValue(url, Student[].class);
            System.out.println("toString from object: " + Arrays.toString(students));

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Student> studentList = Arrays.asList(students);
        return studentList;
    }

    public void saveStudent(Student student) {
        // HW: Look into RestTemplate
    }
}
