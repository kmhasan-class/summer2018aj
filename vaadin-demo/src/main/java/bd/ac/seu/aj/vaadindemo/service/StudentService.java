package bd.ac.seu.aj.vaadindemo.service;

import bd.ac.seu.aj.vaadindemo.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    private ObjectMapper objectMapper;

    public StudentService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // shamelessly stolen from: https://www.baeldung.com/how-to-use-resttemplate-with-basic-authentication-in-spring
    private HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

    public List<Student> getStudent(int studentId) {
        String username = "test";
        String password = "rest";

        RestTemplate restTemplate = new RestTemplate();
        //HttpEntity<Student> studentHttpEntity = new HttpEntity<>(student);
        ResponseEntity<Student> studentResponseEntity = restTemplate.exchange(
                "http://172.17.10.2:8081/student/" + studentId,
                HttpMethod.GET,
                new HttpEntity<>(createHeaders(username, password)),
                Student.class);
        List<Student> studentList = new ArrayList<>();
        if (studentResponseEntity.getStatusCode() == HttpStatus.OK)
            studentList.add(studentResponseEntity.getBody());
        return studentList;
    }

    public List<Student> getAllStudents() {
        // HW: instead of working with fake data, make sure that
        // the data is read from a web service
        String message = "";
        Student[] students = null;
        try {
            URL url = new URL("http://172.17.10.2:8081/student/all");
            students = objectMapper.readValue(url, Student[].class);
            System.out.println("toString from object: " + Arrays.toString(students));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //List<Student> studentList = Arrays.asList(students);
        List<Student> studentList = new ArrayList<>();
        studentList = new ArrayList<>();
        studentList.add(new Student(6442, "John Doe", 3.67));
        return studentList;
    }

    public Student saveStudent(Student student) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Student> studentHttpEntity = new HttpEntity<>(student);
        ResponseEntity<Student> studentResponseEntity = restTemplate.exchange(
                "http://172.17.10.2:8081/student",
                HttpMethod.POST,
                studentHttpEntity,
                Student.class);
        if (studentResponseEntity.getStatusCode() == HttpStatus.CREATED)
            return studentResponseEntity.getBody();
        else throw new Exception(studentResponseEntity.toString());
    }
}
