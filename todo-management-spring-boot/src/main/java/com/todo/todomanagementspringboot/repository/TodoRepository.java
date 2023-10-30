package com.todo.todomanagementspringboot.repository;

import com.todo.todomanagementspringboot.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository< Todo, Long > {
    List<Todo> findByUser(String user);
    Todo findByTodo(String todo);
    List<Todo> findByCompletedTrue();
    List<Todo> findByCompletedFalse();
    List<Todo> findAll();
    Todo getById(Long id);
}
