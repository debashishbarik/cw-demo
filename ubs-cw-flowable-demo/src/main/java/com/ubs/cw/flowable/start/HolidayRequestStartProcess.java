package com.ubs.cw.flowable.start;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

/**
 * The holiday request process engine starting point.
 *
 * @author debashish.barik
 */
public class HolidayRequestStartProcess {

	public static void main(final String[] args) {

		// Step-1 Instantiate a ProcessEngine instance
		final ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
				.setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1").setJdbcUsername("sa").setJdbcPassword("")
				.setJdbcDriver("org.h2.Driver")
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

		final ProcessEngine processEngine = cfg.buildProcessEngine();
		// Note: Flowable use SLF4J as its logging framework add the SLF4J to class path
		// for logs

		// Step-2 deploy a process definition to the Flowable engine.the
		// RepositoryService is used, which can be retrieved from the ProcessEngine
		// object. Using the RepositoryService, a new Deployment is created by passing
		// the location of the XML file and calling the deploy() method to actually
		// execute it:
		final RepositoryService repositoryService = processEngine.getRepositoryService();
		final Deployment deployment = repositoryService.createDeployment()
				.addClasspathResource("holiday-request.bpmn20.xml").deploy();

		// Step-3 We can now verify that the process definition is known to the engine
		final ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deployment.getId()).singleResult();
		System.out.println("Found process definition : " + processDefinition.getName());

		// Step-4 Starting a process instance [Collect Users Data]
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Who are you?");
		final String employee = scanner.nextLine();
		System.out.println("How many holidays do you want to request?");
		final Integer nrOfHolidays = Integer.valueOf(scanner.nextLine());

		System.out.println("Why do you need them?");
		final String description = scanner.nextLine();

		// Step-5 we can start a process instance through the RuntimeService.
		final RuntimeService runtimeService = processEngine.getRuntimeService();
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("employee", employee);// link with flowable:assignee="${employee}" inside xml at runtime
		variables.put("nrOfHolidays", nrOfHolidays);
		variables.put("description", description);
		final ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayRequest", variables);

		// STep-6 get the actual task list, we create a TaskQuery through the
		// TaskService (org.flowable.engine)
		final TaskService taskService = processEngine.getTaskService();
		final List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("managers").list();
		System.out.println("You have " + tasks.size() + " tasks:");
		for (int i = 0; i < tasks.size(); i++) {
			System.out.println((i + 1) + ") " + tasks.get(i).getName());
		}
		// Using the task identifier, we can now get the specific process instance
		// variables and show on the screen the actual request:
		System.out.println("Which task would you like to complete?");
		final int taskIndex = Integer.valueOf(scanner.nextLine());
		final Task task = tasks.get(taskIndex - 1);
		final Map<String, Object> processVariables = taskService.getVariables(task.getId());
		System.out.println(processVariables.get("employee") + " wants " + processVariables.get("nrOfHolidays")
				+ " of holidays. Do you approve this?");

		// Step-7 Approved or Rejected [Call External system]
		final boolean approved = scanner.nextLine().toLowerCase().equals("y");
		variables = new HashMap<String, Object>();
		variables.put("approved", approved);
		taskService.complete(task.getId(), variables);

		// Step - 8 Last Step: Working with historical data for Reporting.
		final HistoryService historyService = processEngine.getHistoryService();
		final List<HistoricActivityInstance> activities = historyService.createHistoricActivityInstanceQuery()
				.processInstanceId(processInstance.getId()).finished().orderByHistoricActivityInstanceEndTime().asc()
				.list();

		for (final HistoricActivityInstance activity : activities) {
			System.out.println(activity.getActivityId() + " took " + activity.getDurationInMillis() + " milliseconds");
		}
		scanner.close();
	}

}
