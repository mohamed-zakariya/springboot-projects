package com.example.taskTracker.cli;

import com.example.taskTracker.enums.TaskStatus;
import com.example.taskTracker.model.Task;
import com.example.taskTracker.service.TaskService;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "mark-done", description = "Mark a task as done")
public class MarkDoneCommand implements Runnable {

    private final TaskService taskService;

    public MarkDoneCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Parameters(index = "0", description = "Task ID")
    private Long id;

    @Override
    public void run() {
        Task task = taskService.updateTaskStatus(id, TaskStatus.DONE);
        System.out.println(task != null ? "Task marked as done." : "Task not found.");
    }
}
