package com.ubs.cw.aop.services;

import org.springframework.stereotype.Service;

import com.ubs.cw.aop.dao.GreetingDao;

@Service
public class GreetingService {

	GreetingDao greetingDao;

	public GreetingService(final GreetingDao greetingDao) {
		this.greetingDao = greetingDao;
	}

	public String retrieveGreetingMessages() {
		final String value = greetingDao.retrieveGreetingMessages();
		return value;
	}
}
