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
public class ServiceAccessAspect {

	// log.info("Received greetings: {}", greetings);

	@Before("execution(* com.ubs.cw.aop.services.*.*(..))")
	public void beforeService(final JoinPoint joinPoint) {
		// Advice
		log.debug(" Start service execution for {}", joinPoint);
		System.out.println("Start service execution for {}" + joinPoint);

	}

	@After(value = "execution(* com.ubs.cw.aop.services.*.*(..))")
	public void after(final JoinPoint joinPoint) {
		log.debug("After service execution of {}", joinPoint);
	}

}
