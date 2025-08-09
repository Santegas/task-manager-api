package com.taskmanager.task_manager_api.controllers;

import com.taskmanager.task_manager_api.shared.domain.task.dto.TaskRequestDTO;
import com.taskmanager.task_manager_api.shared.domain.task.dto.TaskResponseDTO;
import com.taskmanager.task_manager_api.shared.domain.task.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO requestDTO){
        TaskResponseDTO newSavedTask = taskService.createTask(requestDTO);
        return ResponseEntity.ok(newSavedTask);
    }

    @GetMapping
    public ResponseEntity<TaskResponseDTO> getTaskByTitle(@RequestParam(name = "title") String title){
        Optional<TaskResponseDTO> task = taskService.findByTitle(title);

        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id){
        Optional<TaskResponseDTO> task = taskService.findById(id);

        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequestDTO requestDTO){
        Optional<TaskResponseDTO> updateTask = taskService.updateTask(id, requestDTO);

        return updateTask.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        boolean isDeleted = taskService.deleteTask(id);
        if (isDeleted){
            return ResponseEntity.noContent().build();

        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
