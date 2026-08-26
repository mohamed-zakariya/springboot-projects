package com.example.taskTracker.cli;

import com.example.taskTracker.enums.TaskStatus;
import com.example.taskTracker.model.Task;
import com.example.taskTracker.service.TaskService;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;


@Component
@Command(
        name = "mark-in-progress",
        description = "Mark a task as in progress"
)
public class MarkInProgressCommand implements Runnable {

    private final TaskService taskService;

    public MarkInProgressCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Parameters(index = "0", description = "Task ID")
    private Long id;

    @Override
    public void run() {
        Task task = taskService.updateTaskStatus(id, TaskStatus.INPROGRESS);
        if(task != null){
            System.out.println("Task marked as in progress.");
        }
        else {
            System.out.println("Task not found.");
        }
    }
}
