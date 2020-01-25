package com.ubs.cw.demo.cwdemoproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.debashish.aop.demoaopparent.service.CoreServiceI;

@SpringBootTest
class CwDemoProjectApplicationTests {

	@Autowired
	CoreServiceI service;

	@Test
	void contextLoads() {
		service.k();
		service.m();
		service.msg();
	}

}
