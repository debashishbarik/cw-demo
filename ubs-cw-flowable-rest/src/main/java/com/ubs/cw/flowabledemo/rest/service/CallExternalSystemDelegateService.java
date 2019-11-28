package com.ubs.cw.flowabledemo.rest.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * Delegate call to external system after approval.
 *
 * @author debashish.barik
 */
public class CallExternalSystemDelegateService implements JavaDelegate {

	/**
	 * Calling the external system
	 *
	 * @param execution the execution
	 */
	public void execute(final DelegateExecution execution) {
		System.out.println("Calling the external system for employee " + execution.getVariable("employee")
				+ ", applied for " + execution.getVariable("nrOfHolidays") + " number of holiday . Due to "
				+ execution.getVariable("description"));

	}

}
