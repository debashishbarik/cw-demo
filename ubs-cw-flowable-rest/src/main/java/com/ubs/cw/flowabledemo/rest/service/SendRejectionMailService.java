package com.ubs.cw.flowabledemo.rest.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * Send rejection mail to employee.
 * 
 * @author debashish.barik
 */
public class SendRejectionMailService implements JavaDelegate {

	/**
	 * Send leave rejected mail to employee.
	 *
	 * @param execution the execution
	 */
	@Override
	public void execute(final DelegateExecution execution) {
		System.out.println("Sending leave rejection email to employee " + execution.getVariable("employee")
				+ ", who applied for " + execution.getVariable("nrOfHolidays") + " number of holiday . Due to "
				+ execution.getVariable("description"));
	}

}
