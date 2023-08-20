package springboot.gettingstarted.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.gettingstarted.demo.Models.Book;
import java.util.Map;

@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/hell")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	@GetMapping("/{id}")
	public Book getBook(@PathVariable int id) {
		return new Book(id);
	}
	@PostMapping("/request")
	public ResponseEntity<String> postController(
			@RequestBody Book book) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "foo");
		return ResponseEntity.badRequest()
				.body("You suck");
	}

	@GetMapping("/double")
	public ResponseEntity<String> doubleNumber(@RequestHeader("my-number") int myNumber) {
		return new ResponseEntity<String>(String.format("%d * 2 = %d",
				myNumber, (myNumber * 2)), HttpStatus.OK);
	}
	@GetMapping("/listHeaders")
	public ResponseEntity<String> listAllHeaders(
			@RequestHeader Map<String, String> headers) {
		return new ResponseEntity<String>(
				String.format("Listed %d headers", headers.size()), HttpStatus.OK);
	}

}
