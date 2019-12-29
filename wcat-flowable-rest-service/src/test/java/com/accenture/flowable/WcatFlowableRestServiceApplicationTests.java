package com.accenture.flowable;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.test.Deployment;
import org.flowable.spring.impl.test.FlowableSpringExtension;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(FlowableSpringExtension.class)
@SpringBootTest
class WcatFlowableRestServiceApplicationTests {

	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;

	@Test
	@Deployment(resources = { "processes/holiday-request.bpmn20.xml" })
	void articleApprovalTest() {

		final Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("employee", "Debahsih Barik");// link with flowable:assignee="${employee}" inside xml
		variables.put("nrOfHolidays", "12");
		variables.put("description", "New Year");

		runtimeService.startProcessInstanceByKey("holidayRequest", variables);
		final Task task = taskService.createTaskQuery().singleResult();
		assertEquals("Approve or reject request", task.getName());
		variables.put("approved", true);
		taskService.complete(task.getId(), variables);
		assertEquals(1, runtimeService.createProcessInstanceQuery().count());
	}
}
