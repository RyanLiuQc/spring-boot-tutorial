package com.lion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @GetMapping // creates a rest endpoint. within intellij there is a REST client. so no need to use POSTMAN
    public String helloWorld() {
        return "Hello World from Spring Boot";
    }
}
