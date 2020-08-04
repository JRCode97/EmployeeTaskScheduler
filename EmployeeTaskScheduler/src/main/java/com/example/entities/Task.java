package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="task")

public class Task {


	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", done=" + done + ", employee=" + employee + "]";
	}

	public Task(int id, String description, boolean done, Employee employee) {
		super();
		this.id = id;
		this.description = description;
		this.done = done;
		this.employee = employee;
	}

	public Task() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@Column(name="description")
	String description;
	@Column(name="done")
	boolean done;
	@ManyToOne
	@JoinColumn(name="employee_id")
	Employee employee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public void setDone(boolean is_Done) {
		this.done = is_Done;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isDone() {
		return done;
	}
	
}
