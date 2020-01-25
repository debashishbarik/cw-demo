package com.debashish.aop.demoaopparent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.debashish.aop.demoaopparent.service.CoreServiceI;

@SpringBootApplication
public class AopChildAopwApplication {

	static CoreServiceI service = new CustomClasss();

	static void contextLoads() {
		service.k();
		service.m();
		service.msg();
	}

	public static void main(final String[] args) {
		SpringApplication.run(AopChildAopwApplication.class, args);
		contextLoads();
	}

}
