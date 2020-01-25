package com.accenture.flowable.controller;

import com.accenture.flowable.domain.Approval;
import com.accenture.flowable.domain.Holiday;
import com.accenture.flowable.service.HolidayWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holiday")
public class HolidayWorkflowController {

    /** The service. */
    @Autowired
    private HolidayWorkflowService service;

    /**
     * Employee Submit leave request.
     *http://localhost:8090/holiday/submitleave
     *  Ex:
     *  {
     * 	"id":"123",
     * 	"employee":"Debashish Barik",
     * 	"nrOfHolidays":"10",
     * 	"description":"New year holiday"
     * }
     * @param holiday the holiday
     */
    @PostMapping("/submitleave")
    public void submitLeaveRequest(@RequestBody final Holiday holiday) {
        service.startProcess(holiday);
    }

    /**
     * Manager gets all the assigned tasks.
     * http://localhost:8090/holiday/alltasks?assignee=managers
     * @param assignee the assignee
     * @return the tasks
     */
    @GetMapping("/alltasks")
    public List<Holiday> getTasks(@RequestParam final String assignee) {
        return service.getAssignedTasks(assignee);
    }

    /**
     * Manager review leave request and submit Approved - true/false.
     *
     * @param approval the approval
     */
    @PostMapping("/reviewtasks")
    public void reviewLeaveRequest(@RequestBody final Approval approval) {
        service.submitLeaveReview(approval);
    }
}
