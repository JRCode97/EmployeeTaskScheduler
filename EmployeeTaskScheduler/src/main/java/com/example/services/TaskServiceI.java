package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entities.Task;
import com.example.repos.TaskRepo;

public interface TaskServiceI {
	Task createTask(Task t);
	
	Task getTaskById(int id);
	
	Task updateTask(Task t);
}
