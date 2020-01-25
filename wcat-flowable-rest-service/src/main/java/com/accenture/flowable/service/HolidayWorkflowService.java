package com.accenture.flowable.service;

import com.accenture.flowable.domain.Approval;
import com.accenture.flowable.domain.Holiday;

import java.util.List;

public interface HolidayWorkflowService {

    void startProcess(final Holiday holiday);
    List<Holiday> getAssignedTasks(final String assignee);
    void submitLeaveReview(final Approval approval);

}
