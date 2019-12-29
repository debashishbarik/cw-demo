package com.accenture.flowable.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * Delegate call to external system after approval.
 *
 * @author debashish.barik
 */
@Slf4j
public class CallExternalSystemDelegateService implements JavaDelegate {

	/**
	 * Calling the external system
	 *
	 * @param execution the execution
	 */
	public void execute(final DelegateExecution execution) {
	log.debug("Calling the external system for employee " + execution.getVariable("employee")
			+ ", applied for " + execution.getVariable("nrOfHolidays") + " number of holiday . Due to "
			+ execution.getVariable("description"));

	System.out.println("[Console]Calling the external system for employee " + execution.getVariable("employee")
				+ ", applied for " + execution.getVariable("nrOfHolidays") + " number of holiday . Due to "
				+ execution.getVariable("description"));

	}

}
