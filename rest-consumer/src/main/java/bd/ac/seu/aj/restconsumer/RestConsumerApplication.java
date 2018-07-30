package bd.ac.seu.aj.restconsumer;

import bd.ac.seu.aj.restconsumer.service.ReaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class RestConsumerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(RestConsumerApplication.class, args);

		try {
			URL url = new URL("http://172.17.10.2:8080/student/all");
			String response = run.getBean(ReaderService.class).read(url);
			System.out.println(response);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}


	}
}
