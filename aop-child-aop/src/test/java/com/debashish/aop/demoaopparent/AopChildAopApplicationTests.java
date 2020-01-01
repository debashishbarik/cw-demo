package com.debashish.aop.demoaopparent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.debashish.aop.demoaopparent.service.CoreServiceI;

@SpringBootTest
class AopChildAopApplicationTests {

	@Autowired
	CoreServiceI service;

	@Test
	void contextLoads() {
		service.k();
	}

}
