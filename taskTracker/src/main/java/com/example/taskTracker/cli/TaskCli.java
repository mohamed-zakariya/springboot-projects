package com.example.taskTracker.cli;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(
        name = "task-cli",
        description = "Task Tracker CLI",
        mixinStandardHelpOptions = true,
        subcommands = {
                AddCommand.class,
                DeleteCommand.class,
                UpdateCommand.class,
                MarkTodoCommand.class,
                MarkInProgressCommand.class,
                MarkDoneCommand.class,
                ListCommand.class
        }

)
public class TaskCli implements Runnable{
    @Override
    public void run() {
        System.out.println("Use --help to see available commands.");
    }
}
