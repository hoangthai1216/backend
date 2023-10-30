package com.todo.todomanagementspringboot.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    private String description;

    private Date targetDate;

    private boolean completed;

    public Todo(String userName, boolean completed){
        this.userName = userName;
        this.completed = completed;
    }

    public Todo(String user, String desc, Date targetDate, boolean completed) {
        this.userName = user;
        this.description = desc;
        this.targetDate = targetDate;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
