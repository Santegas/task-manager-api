package com.taskmanager.task_manager_api.repositories;


import com.taskmanager.task_manager_api.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository  extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title);
}
