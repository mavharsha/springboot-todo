package com.maverick.harsha.todolist;

import com.maverick.harsha.todo.Todo;
import com.maverick.harsha.user.User;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class TodoList {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private ArrayList<Todo> listOfTodos;

    //Many todo_list for a user
    @ManyToOne
    private User createdUser;

    protected TodoList() {
    }

    public TodoList(long id, String title, ArrayList<Todo> listOfTodos, User createdUser) {
        this.id = id;
        this.title = title;
        this.listOfTodos = listOfTodos;
        this.createdUser = createdUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Todo> getListOfTodos() {
        return listOfTodos;
    }

    public void setListOfTodos(ArrayList<Todo> listOfTodos) {
        this.listOfTodos = listOfTodos;
    }

    public void addToListOfTodos(Todo todo){ this.listOfTodos.add(todo);}

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }
}
