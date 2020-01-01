package com.debashish.aop.demoaopparent;

import com.debashish.aop.demoaopparent.service.CoreServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoAopParentApplicationTests {
	@Autowired
    CoreServiceI coreService;

	@Test
	void contextLoads() {
		coreService.msg();
		coreService.m();
		coreService.k();
	}

}
