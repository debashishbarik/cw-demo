package com.ubs.cw.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingDao {

	public String retrieveGreetingMessages() {
		return "Retrieve Greeting Messages!!!";
	}

}
