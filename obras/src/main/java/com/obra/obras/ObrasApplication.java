package com.obra.obras;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(
		basePackages = {
				"com.obra.obras.repository",
				"com.obra.obras.service",

		} )
@RestController
public class ObrasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObrasApplication.class, args);
	}

	@Value("${application.name}")
	private String applicationName;

	@GetMapping("/hello")
	public String helloWorld(){
		return applicationName;
	}

}
