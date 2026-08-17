package com.example.taskTracker;

import com.example.taskTracker.service.TaskJsonStorage;
import com.example.taskTracker.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackerApplication.class, args);

		TaskJsonStorage taskJsonStorage = new TaskJsonStorage();
		TaskService taskService = new TaskService(taskJsonStorage);
		taskService.createTask("hello");
	}

}