package com.example.taskTracker.cli;


import com.example.taskTracker.enums.TaskStatus;
import com.example.taskTracker.model.Task;
import com.example.taskTracker.service.TaskService;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.List;

@Component
@Command(
        name = "list",
        description = "List Tasks"
)
public class ListCommand implements Runnable{

    private final TaskService taskService;

    public ListCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Parameters(index = "0", arity = "0..1")
    private TaskStatus taskStatus;

    @Override
    public void run() {

        List<Task> tasks = taskService.getTasks(taskStatus);
        if(tasks != null){
            for(Task task: tasks){
                System.out.println(task.toString());
            }
            System.out.println("Tasks Retrieved Successfully");
        }
        else{
            System.out.println("Tasks Retrieved UnSuccessful");
        }
    }
}
