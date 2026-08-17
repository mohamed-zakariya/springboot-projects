package com.example.taskTracker.cli;

import com.example.taskTracker.model.Task;
import com.example.taskTracker.service.TaskService;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "add", description = "Add a new task")
public class AddCommand implements Runnable{
    private final TaskService taskService;

    public AddCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Parameters(index = "0", description = "Task description")
    private String description;

    @Override
    public void run() {

        Task task = taskService.createTask(description);

        System.out.println(
                "Task added successfully (ID: " + task.getId() + ")"
        );
    }
}
