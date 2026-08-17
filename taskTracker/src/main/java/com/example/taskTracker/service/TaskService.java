package com.example.taskTracker.service;

import com.example.taskTracker.enums.TaskStatus;
import com.example.taskTracker.model.Task;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TaskService {

    @Getter
    private final List<Task> tasks = new ArrayList<>();
    private final TaskJsonStorage storage;

    public TaskService(TaskJsonStorage storage) {
        this.storage = storage;
    }

    public Long generateNextId(List<Task> tasks){
        return tasks.stream()
                .map(Task::getId)
                .filter(Objects::nonNull)
                .max(Long::compareTo)
                .orElse(0L) + 1;
    }

    public Task createTask(String description){
        Task task = new Task();

        task.setId(generateNextId(tasks));
        task.setDescription(description);
        task.setStatus(TaskStatus.TODO);

        LocalDateTime now = LocalDateTime.now();

        task.setCreatedAt(now);
        task.setUpdatedAt(now);

        tasks.add(task);
        storage.saveTasks(tasks);

        return task;
    }

    public Boolean deleteTask(Long id){
        boolean remove = tasks.removeIf(
                task -> task.getId() != null && task.getId().equals(id)
        );
        if(remove){
            storage.saveTasks(tasks);
        }
        return remove;
    }

    public List<Task> getTasksByStatus(TaskStatus taskStatus){
        return tasks.stream()
                .filter(task -> task.getStatus() == taskStatus)
                .toList();
    }

    public Task updateTask(Long id, String description, TaskStatus taskStatus){
        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (task == null){
            return null;
        }
        if(description != null){
            task.setDescription(description);
        }
        if (taskStatus != null){
            task.setStatus(taskStatus);
        }
        task.setUpdatedAt(LocalDateTime.now());

        storage.saveTasks(tasks);
        return task;

    }


}
