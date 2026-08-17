package com.example.taskTracker.model;


import com.example.taskTracker.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Task {
     private Long id;
     private String description;
     private TaskStatus status;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;


}
