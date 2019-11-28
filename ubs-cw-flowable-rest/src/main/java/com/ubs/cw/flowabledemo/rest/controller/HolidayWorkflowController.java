/**
 *
 */
package com.ubs.cw.flowabledemo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.cw.flowabledemo.rest.domain.Approval;
import com.ubs.cw.flowabledemo.rest.domain.Holiday;
import com.ubs.cw.flowabledemo.rest.service.HolidayWorkflowService;

/**
 * HolidayWorkflowController.
 *
 * @author debashish.barik
 */
@RestController
public class HolidayWorkflowController {

	/** The service. */
	@Autowired
	private HolidayWorkflowService service;

	/**
	 * Submit.
	 *
	 * @param holiday the holiday
	 */
	@PostMapping("/submitleave")
	public void submitLeaveRequest(@RequestBody final Holiday holiday) {
		service.startProcess(holiday);
	}

	/**
	 * Gets the Assigned tasks.
	 *
	 * @param assignee the assignee
	 * @return the tasks
	 */
	@GetMapping("/alltasks")
	public List<Holiday> getTasks(@RequestParam final String assignee) {
		return service.getAssignedTasks(assignee);
	}

	/**
	 * Review leave request.
	 *
	 * @param approval the approval
	 */
	@PostMapping("/reviewtasks")
	public void reviewLeaveRequest(@RequestBody final Approval approval) {
		service.submitLeaveReview(approval);
	}

}
