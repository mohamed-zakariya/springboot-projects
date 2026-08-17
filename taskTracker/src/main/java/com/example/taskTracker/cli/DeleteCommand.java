package com.example.taskTracker.cli;

import com.example.taskTracker.service.TaskService;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "delete", description = "Delete a task")
public class DeleteCommand implements Runnable {

    private final TaskService taskService;

    public DeleteCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Parameters(index = "0")
    private Long id;

    @Override
    public void run() {

        boolean deleted = taskService.deleteTask(id);

        if (deleted) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }
}