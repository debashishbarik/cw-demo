package com.accenture.flowable.service.impl;

import com.accenture.flowable.domain.Approval;
import com.accenture.flowable.domain.Holiday;
import com.accenture.flowable.service.HolidayWorkflowService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Holiday Workflow Service.
 *
 * @author debashish.barik
 */
@Slf4j
@Service
public class HolidayWorkflowServiceImpl  implements HolidayWorkflowService {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /**
     * Start process by submitting a leave request.
     *
     * @param holiday
     */
    @Override
    @Transactional
    public void startProcess(Holiday holiday) {
        final Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", holiday.getEmployee());// link with flowable:assignee="${employee}" inside xml
        variables.put("nrOfHolidays", holiday.getNrOfHolidays());
        variables.put("description", holiday.getDescription());
        runtimeService.startProcessInstanceByKey("holidayRequest", variables);
    }

    /**
     * Gets the assigned tasks for reviewing leave request.
     *
     * @param assignee
     * @return
     */
    @Override
    @Transactional
    public List<Holiday> getAssignedTasks(String assignee) {
        System.out.println("GetTasks");
        // assignee = "managers"
        final List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(assignee).list();

        final List<Holiday> holidayListForReview = tasks.stream().map(task -> {
            final Map<String, Object> variables = taskService.getVariables(task.getId());
            return new Holiday(task.getId(), (String) variables.get("employee"), (String) variables.get("nrOfHolidays"),
                    (String) variables.get("description"));
        }).collect(Collectors.toList());
        return holidayListForReview;
    }

    /**
     * Managers submit leave review approved or rejected.
     *
     * @param approval
     */
    @Override
    @Transactional
    public void submitLeaveReview(Approval approval) {
        final Map<String, Object> variables = new HashMap<String, Object>();
        System.out.println("is Approved:" + approval.isApproved());
        variables.put("approved", approval.isApproved());
        taskService.complete(approval.getId(), variables);
    }
}
