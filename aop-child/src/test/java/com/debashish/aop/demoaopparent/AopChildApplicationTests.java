package com.debashish.aop.demoaopparent;

import com.debashish.aop.demoaopparent.service.CoreServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopChildApplicationTests {

	@Autowired
	CoreServiceI service;


	@Test
	void contextLoads() {

		service.k();
		service.m();
		service.msg();
	}

}
