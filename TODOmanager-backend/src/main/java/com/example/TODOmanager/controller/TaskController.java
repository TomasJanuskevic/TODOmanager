package com.example.TODOmanager.controller;

import com.example.TODOmanager.exception.TaskNotFoundException;
import com.example.TODOmanager.model.Task;
import com.example.TODOmanager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.findAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) throws TaskNotFoundException {
        return new ResponseEntity<>(taskService.findTaskById(id), HttpStatus.OK);
    }

    @PostMapping("/tasks")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/tasks")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> updateTask(@RequestBody Task task){
        taskService.updateTask(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) throws TaskNotFoundException {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
