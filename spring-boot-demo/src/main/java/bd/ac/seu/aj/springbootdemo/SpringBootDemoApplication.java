package bd.ac.seu.aj.springbootdemo;

import bd.ac.seu.aj.springbootdemo.model.Student;
import bd.ac.seu.aj.springbootdemo.repository.StudentRepository;
import bd.ac.seu.aj.springbootdemo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootDemoApplication.class, args);

		StudentService studentService = run.getBean(StudentService.class);
		studentService.getStudents().forEach(System.out::println);
	}
}
