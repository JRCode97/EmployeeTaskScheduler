package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.entities.Employee;
import com.example.entities.Task;
import com.example.services.EmployeeService;
import com.example.services.TaskService;

@SpringBootTest
@ContextConfiguration(classes=com.example.app.EmployeeTaskSchedulerApplication.class)

class EmployeeTaskSchedulerApplicationTests {
	@Autowired
	EmployeeService es;
	@Autowired 
	TaskService ts;
	@Test
	void test() {
		//System.out.println(es.createEmployee(new Employee(0,"Jesse Rivera","Junior Java Developer")));
	System.out.println(ts.createTask(new Task(0,"Do Scheduler Assignment",false,es.getEmployeeById(1))));
	}

}
