package com.maverick.harsha.todo;

import com.maverick.harsha.TodoStatus;
import com.maverick.harsha.user.User;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private long id;

    //Many TODOs for a user
    @ManyToOne
    private User createdUser;

    @Column
    private String title;

    @Column(length = 2000)
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private TodoStatus todoStatus = TodoStatus.PENDING;

    @Column(length = 500)
    private DateTime createdTime;

    @Column(length = 500)
    private DateTime deadLine;

    protected Todo() {
    }

    public Todo(User createdUser, String title, String description, TodoStatus todoStatus, DateTime createdTime, DateTime deadLine) {
        this.createdUser = createdUser;
        this.title = title;
        this.description = description;
        this.todoStatus = todoStatus;
        this.createdTime = createdTime;
        this.deadLine = deadLine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoStatus getTodoStatus(){ return todoStatus; }

    public void setTodoStatus(TodoStatus status){ this.todoStatus = status; }

    public DateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(DateTime createdTime) {
        this.createdTime = createdTime;
    }

    public DateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(DateTime deadLine) {
        this.deadLine = deadLine;
    }
}
