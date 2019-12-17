package com.ubs.cw.aop.services;

import org.springframework.stereotype.Service;

import com.ubs.cw.aop.dao.EntryDao;

@Service
public class EntryService {

	EntryDao entryDao;

	public EntryService(final EntryDao entryDao) {
		super();
		this.entryDao = entryDao;
	}

	public String retrieveEntryDetails() {
		final String value = entryDao.retrieveEntryDetails();
		return value;
	}

}
