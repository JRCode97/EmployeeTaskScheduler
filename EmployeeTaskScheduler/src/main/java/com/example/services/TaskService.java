package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entities.Task;
import com.example.repos.TaskRepo;
@Component
@Service
public class TaskService implements TaskServiceI{
	@Autowired
	private TaskRepo tr;
	@Override
	public Task createTask(Task t) {
		return tr.save(t);
	}

	@Override
	public Task getTaskById(int id) {
		return tr.findById(id).get();
	}

	@Override
	public Task updateTask(Task t) {
		return tr.save(t);
	}

}
