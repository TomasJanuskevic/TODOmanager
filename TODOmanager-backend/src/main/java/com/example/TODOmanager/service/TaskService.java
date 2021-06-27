package com.example.TODOmanager.service;

import com.example.TODOmanager.exception.TaskNotFoundException;
import com.example.TODOmanager.model.Task;
import com.example.TODOmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id) throws TaskNotFoundException {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task by id: " + id + " was not found."));
    }

    public void addTask(Task task) {
        taskRepository.save(task);
        log.info("Task was added");
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
        log.info("Task updated successfully");
    }

    public void deleteTask(Long id) throws TaskNotFoundException {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            log.info("Task with id " + id + " deleted successfully");
        } else {
            throw new TaskNotFoundException("Task by id: " + id + " was not found.");
        }
    }
}
