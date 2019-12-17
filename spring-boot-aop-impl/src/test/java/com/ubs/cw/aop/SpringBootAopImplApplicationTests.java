package com.ubs.cw.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ubs.cw.aop.services.EntryService;
import com.ubs.cw.aop.services.ExitService;
import com.ubs.cw.aop.services.GreetingService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SpringBootAopImplApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private GreetingService business1;

	@Autowired
	private EntryService business2;

	@Autowired
	private ExitService business3;

	@Test
	public void invokeAOPStuff() {
		log.info(business1.retrieveGreetingMessages());
		log.info(business2.retrieveEntryDetails());
		log.info(business3.retrieveExitDetails());

	}
}
