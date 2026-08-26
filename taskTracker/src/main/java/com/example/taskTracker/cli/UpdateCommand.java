package com.example.taskTracker.cli;

import com.example.taskTracker.model.Task;
import com.example.taskTracker.service.TaskService;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "update", description = "Update a task")
public class UpdateCommand implements Runnable {

    private final TaskService taskService;

    public UpdateCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Parameters(index = "0")
    private Long id;

    @Parameters(index = "1")
    private String description;

    @Override
    public void run() {

        Task task = taskService.updateTask(
                id,
                description
        );

        if (task != null) {
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }
}
