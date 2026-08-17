package com.example.taskTracker.controller;

import com.example.taskTracker.enums.TaskStatus;
import com.example.taskTracker.model.Task;
import com.example.taskTracker.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/checkhealth")
    public String checkHealth(){
        return "The Server is working Successfully";
    }

    @PostMapping
    public Task createTask(@RequestParam String description){
        return taskService.createTask(description);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(
            @RequestParam(required = false) TaskStatus status) {

        if (status != null) {
            return ResponseEntity.ok(taskService.getTasksByStatus(status));
        }

        return ResponseEntity.ok(taskService.getTasks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        if(taskService.deleteTask(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id,
                                           @RequestParam String description,
                                           @RequestParam TaskStatus taskStatus){
        Task task = taskService.updateTask(id, description, taskStatus);
        if (task != null){
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }



}
