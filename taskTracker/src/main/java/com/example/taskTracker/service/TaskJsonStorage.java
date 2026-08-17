package com.example.taskTracker.service;

import com.example.taskTracker.model.Task;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskJsonStorage {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final File file = new File("tasks.json");

    public List<Task> loadTasks(){
        try {
            if (!file.exists()){
                return new ArrayList<>();
            }
            return objectMapper.readValue(
                    file,
                    new TypeReference<List<Task>>() {}
            );
        }
        catch (Exception e){
            throw new RuntimeException("Could not load tasks", e);
        }
    }

    public void saveTasks(List<Task> tasks){
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(file, tasks);
        }
        catch (Exception e){
            throw new RuntimeException("Could not save tasks", e);
        }
    }

}
