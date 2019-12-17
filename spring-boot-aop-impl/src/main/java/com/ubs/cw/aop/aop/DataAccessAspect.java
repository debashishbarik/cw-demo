package com.ubs.cw.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class DataAccessAspect {

	@Before("execution(* com.ubs.cw.aop.dao.*.*(..))")
	public void beforeService(final JoinPoint joinPoint) {
		// Advice
		log.debug(" Start DAO execution for {}", joinPoint);
		System.out.println("Start DAO execution for {}dd" + joinPoint);
		// Ex: execution(String
		// com.ubs.cw.aop.dao.GreetingDao.retrieveGreetingMessages())
	}

	@After(value = "execution(* com.ubs.cw.aop.dao.*.*(..))")
	public void after(final JoinPoint joinPoint) {
		log.debug("After DAO execution of {}", joinPoint);
	}

}
