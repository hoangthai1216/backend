package com.todo.todomanagementspringboot.controller;

import com.todo.todomanagementspringboot.model.Todo;
import com.todo.todomanagementspringboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTasks() {
        return ResponseEntity.ok(todoService.getAllTodo());
    }
    @GetMapping("/completed")
    public ResponseEntity<List<Todo>> getAllCompletedTasks() {
        return ResponseEntity.ok(todoService.findAllCompletedTodo());
    }
    @GetMapping("/incomplete")
    public ResponseEntity<List<Todo>> getAllIncompleteTasks() {
        return ResponseEntity.ok(todoService.findAllInCompleteTodo());
    }
    @PostMapping("/")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.createNewTodo(todo));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        todo.setId(id);
        return ResponseEntity.ok(todoService.updateTodo(todo));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping(value = "/user/{username}")
    public ResponseEntity<List<Todo>> showTodosByUser(@PathVariable String username) {
        return ResponseEntity.ok(todoService.findByUser(username));
    }
}