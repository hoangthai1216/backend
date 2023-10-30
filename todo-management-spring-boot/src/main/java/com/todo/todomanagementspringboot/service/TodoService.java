package com.todo.todomanagementspringboot.service;

import com.todo.todomanagementspringboot.model.Todo;
import com.todo.todomanagementspringboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService{

    @Autowired
    private TodoRepository todoRepository;

    public Todo createNewTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public Todo findTodoById(Long id) {
        return todoRepository.getById(id);
    }

    public List<Todo> findAllCompletedTodo() {
        return todoRepository.findByCompletedTrue();
    }

    public List<Todo> findAllInCompleteTodo() {
        return todoRepository.findByCompletedFalse();
    }

    public void deleteTodo(Long id) {
        Optional <Todo> todo = todoRepository.findById(id);
        todo.ifPresent(value -> todoRepository.delete(value));
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> findByUser (String username){
        return todoRepository.findByUser(username);
    }
}
