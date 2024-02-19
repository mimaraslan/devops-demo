package com.mimaraslan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AppMain {

	@GetMapping
	public String message(){
		return "Welcome to DevOps";
	}

	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}

}
