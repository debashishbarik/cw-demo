package com.ubs.cw.flowable.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * Send rejection mail to employee.
 */
public class SendRejectionMail implements JavaDelegate {

	/**
	 * Send leave rejected mail to employee.
	 *
	 * @param execution the execution
	 */
	public void execute(final DelegateExecution execution) {
		System.out.println("Sending leave rejection email to employee " + execution.getVariable("employee")
				+ ", who applied for " + execution.getVariable("nrOfHolidays") + " number of holiday . Due to "
				+ execution.getVariable("description"));
	}

}
