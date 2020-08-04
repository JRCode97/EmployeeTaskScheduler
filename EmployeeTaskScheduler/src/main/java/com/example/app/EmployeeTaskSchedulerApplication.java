package com.example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.entities.Employee;
import com.example.entities.Task;
import com.example.services.EmployeeService;
import com.example.services.TaskService;
@EnableScheduling
@EnableJpaRepositories(basePackages="com.example.repos") 
@SpringBootApplication(scanBasePackages="com.example.*")
@EntityScan("com.example.entities")
public class EmployeeTaskSchedulerApplication {
	@Autowired
	EmployeeService es;
	@Autowired
	TaskService ts;
	boolean skip = false;
	int count = 0;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeTaskSchedulerApplication.class, args);
	}
	
    @Scheduled(fixedRate = 1000L)
    void CheckEmployee() {
    	if(count==1) {
    		skip = !skip;
    		count = 0;
    		}
    	if(skip==false) {
    	System.out.println("\n");
    	Employee me = es.getEmployeeById(1);
    	System.out.println(me);

    	List<Task> tasks=me.getTasks();


    	for(Task task:tasks) {
    		System.out.println("checking task"+task.getDescription());
    		if(task.isDone())
    		{
    			System.out.println("you completed this task"+task.getDescription());
    			skip=true;
    			
    		}
    		else {
    			System.out.println("did not complete");
    			task.setDone(true);
    			ts.updateTask(task);
    			System.out.println("task status: "+task.isDone());
    		}
    	
    		
    		
    	}}
    	else {
    		count++;
    		System.out.println("skipped this many times"+count);
    	}
    	
    }

}
