package com.example.services;

import com.example.entities.Employee;

public interface EmployeeServiceI {
	public Employee createEmployee(Employee e);
	
	public Employee getEmployeeById(int id);
	
	public Employee updateEmployee(Employee e);
}
