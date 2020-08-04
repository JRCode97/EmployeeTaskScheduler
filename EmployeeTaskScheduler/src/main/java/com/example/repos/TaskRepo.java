package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Task;

public interface TaskRepo extends JpaRepository<Task,Integer>{

}
