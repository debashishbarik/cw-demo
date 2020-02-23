package com.debashish.springdrools.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.debashish.springdrools.model.RawData;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ExceptionController {

	private final KieSession session;

	@PostMapping("/exception")
	public com.debashish.springdrools.model.Exception orderNow(@RequestBody final RawData rawData) {
		session.insert(rawData);
		session.fireAllRules();

		final RawData rawDataUpdated = rawData;
		final com.debashish.springdrools.model.Exception exception = new com.debashish.springdrools.model.Exception();
		exception.setFunctionId(rawDataUpdated.getFunctionId());
		exception.setLegalEntityId(rawData.getLegalEntityId());
		exception.setReportinDate(rawData.getReportinDate());
		exception.setStatus(rawData.getStatus());
		return exception;
	}
}
