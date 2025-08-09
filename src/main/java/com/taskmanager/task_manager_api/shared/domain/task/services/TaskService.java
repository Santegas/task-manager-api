package com.taskmanager.task_manager_api.shared.domain.task.services;

import com.taskmanager.task_manager_api.entities.Task;
import com.taskmanager.task_manager_api.repositories.TaskRepository;
import com.taskmanager.task_manager_api.shared.domain.task.dto.TaskRequestDTO;
import com.taskmanager.task_manager_api.shared.domain.task.dto.TaskResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskResponseDTO createTask(TaskRequestDTO requestDTO){
        Task task = new Task();
        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());
        task.setStatus(requestDTO.getStatus());
        task.setDueDate(requestDTO.getDueDate());

        Task savedTask = taskRepository.save(task);

        TaskResponseDTO responseDTO = new TaskResponseDTO();
        responseDTO.setId(savedTask.getId());
        responseDTO.setTitle(savedTask.getTitle());
        responseDTO.setDescription(savedTask.getDescription());
        responseDTO.setStatus(savedTask.getStatus());
        responseDTO.setDueDate(savedTask.getDueDate());

        return responseDTO;
    }

    public Optional<TaskResponseDTO> findByTitle(String title){
        Optional<Task> task = taskRepository.findByTitle(title);

        return task.map(t -> {
            TaskResponseDTO responseDTO = new TaskResponseDTO();
            responseDTO.setId(t.getId());
            responseDTO.setTitle(t.getTitle());
            responseDTO.setDescription(t.getDescription());
            responseDTO.setStatus(t.getStatus());
            responseDTO.setDueDate(t.getDueDate());
            return responseDTO;
        });
    }

    public Optional<TaskResponseDTO> findById(Long id){
        Optional<Task> task = taskRepository.findById(id);

        return task.map(t -> {
            TaskResponseDTO responseDTO = new TaskResponseDTO();
            responseDTO.setId(t.getId());
            responseDTO.setTitle(t.getTitle());
            responseDTO.setDescription(t.getDescription());
            responseDTO.setStatus(t.getStatus());
            responseDTO.setDueDate(t.getDueDate());
            return responseDTO;
        });
    }

    public Optional<TaskResponseDTO> updateTask(Long id, TaskRequestDTO requestDTO){
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()){
            Task existingTask = taskOptional.get();

            existingTask.setTitle(requestDTO.getTitle());
            existingTask.setDescription(requestDTO.getDescription());
            existingTask.setStatus(requestDTO.getStatus());
            existingTask.setDueDate(requestDTO.getDueDate());

            Task updateTask =taskRepository.save(existingTask);

            TaskResponseDTO responseDTO = new TaskResponseDTO();
            responseDTO.setId(updateTask.getId());
            responseDTO.setTitle(updateTask.getTitle());
            responseDTO.setDescription(updateTask.getDescription());
            responseDTO.setStatus(updateTask.getStatus());
            responseDTO.setDueDate(updateTask.getDueDate());

            return Optional.of(responseDTO);
        }else {
            return Optional.empty();
        }
    }

    public boolean deleteTask(Long id){
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
