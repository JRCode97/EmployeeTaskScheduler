package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entities.Employee;
import com.example.repos.EmployeeRepo;
@Component
@Service
public class EmployeeService implements EmployeeServiceI{
	@Autowired
	EmployeeRepo er;
	@Override
	public Employee createEmployee(Employee e) {
		return er.save(e);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return er.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee e) {
		return er.save(e);
	}

}
