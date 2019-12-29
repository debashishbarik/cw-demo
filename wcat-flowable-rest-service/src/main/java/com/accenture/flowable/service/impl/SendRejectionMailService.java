package com.accenture.flowable.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * Send rejection mail to employee.
 * 
 * @author debashish.barik
 */
@Slf4j
public class SendRejectionMailService implements JavaDelegate {

	/**
	 * Send leave rejected mail to employee.
	 *
	 * @param execution the execution
	 */
	@Override
	public void execute(final DelegateExecution execution) {
		log.debug("Sending leave rejection email to employee " + execution.getVariable("employee")
				+ ", who applied for " + execution.getVariable("nrOfHolidays") + " number of holiday . Due to "
				+ execution.getVariable("description"));
		System.out.println("[Console]Sending leave rejection email to employee " + execution.getVariable("employee")
				+ ", who applied for " + execution.getVariable("nrOfHolidays") + " number of holiday . Due to "
				+ execution.getVariable("description"));
	}

}
