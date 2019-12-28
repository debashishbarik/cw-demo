package com.example.multimodule.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.multimodule.service.MyService;

@SpringBootApplication(scanBasePackages = "com.example.multimodule")
@RestController
public class DemoApplication {

	private final MyService myService;

	public DemoApplication(final MyService myService) {
		this.myService = myService;
	}

	@GetMapping("/")
	public String home() {
		return myService.message();
	}

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
