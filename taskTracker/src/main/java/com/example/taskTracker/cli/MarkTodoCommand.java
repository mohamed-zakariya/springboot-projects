package com.example.taskTracker.cli;

import com.example.taskTracker.enums.TaskStatus;
import com.example.taskTracker.model.Task;
import com.example.taskTracker.service.TaskService;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "mark-todo", description = "Mark a task as to do")
public class MarkTodoCommand implements Runnable {

    private final TaskService taskService;

    public MarkTodoCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Parameters(index = "0", description = "Task ID")
    private Long id;

    @Override
    public void run() {
        Task task = taskService.updateTaskStatus(id, TaskStatus.TODO);
        System.out.println(task != null ? "Task marked as to do." : "Task not found.");
    }
}
