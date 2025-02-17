package com.ngsignaltask.backend.services;

import com.ngsignaltask.backend.model.Task;
import com.ngsignaltask.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get task by ID
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    // Create a new task
    public Task createTask(Task task) {
        System.out.println("Received task. " + task);
        return taskRepository.save(task);
    }

    // Update an existing task
    public Task updateTask(Long id, Task task) {
        if (!taskRepository.existsById((id))) {
            throw new RuntimeException("Task not found with id: " + id);
        }
        task.setId(id);
        return taskRepository.save(task);
    }

    // Delete a task by ID
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }


}
