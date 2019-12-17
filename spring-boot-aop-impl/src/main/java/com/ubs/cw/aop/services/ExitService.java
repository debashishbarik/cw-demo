package com.ubs.cw.aop.services;

import org.springframework.stereotype.Service;

import com.ubs.cw.aop.dao.ExitDao;

@Service
public class ExitService {

	ExitDao exitdao;

	public String retrieveExitDetails() {
		final String value = exitdao.retrieveExitDetails();
		return value;
	}

	public ExitService(final ExitDao exitdao) {
		super();
		this.exitdao = exitdao;
	}

}
