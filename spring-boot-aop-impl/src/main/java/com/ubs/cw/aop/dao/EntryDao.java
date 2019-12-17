package com.ubs.cw.aop.dao;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class EntryDao {

	public String retrieveEntryDetails() {

		return "retrieve Entry Details";
	}

}
