package com.ubs.cw.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingDao {

	public String retrieveGreetingMessages() {
		Callingngngn();
		return "Retrieve Greeting Messages!!!";
	}

	private String Callingngngn() {
		return "Call;;;;";
	}
}
