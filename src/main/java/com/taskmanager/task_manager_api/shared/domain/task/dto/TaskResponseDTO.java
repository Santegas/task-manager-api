package com.taskmanager.task_manager_api.shared.domain.task.dto;

import com.taskmanager.task_manager_api.enumns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDateTime dueDate;

}
