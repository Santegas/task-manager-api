package com.taskmanager.task_manager_api.shared.domain.task.dto;

import com.taskmanager.task_manager_api.enumns.Status;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Data
public class TaskRequestDTO {

    @NotBlank(message = "O título não pode estar em branco")
    private String title;

    private String description;

    @NotNull(message = "O status não pode ser nulo")
    private Status status;

    private LocalDateTime dueDate;
}
