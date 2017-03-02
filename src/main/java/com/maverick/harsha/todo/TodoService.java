package com.maverick.harsha.todo;

import com.maverick.harsha.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harsha on 2/22/2017.
 */
@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll(){
        ArrayList<Todo> todoList = new ArrayList<>();
        todoRepository.findAll().forEach(todo -> todoList.add(todo));
        return todoList;
    }

    public Todo findOneById(Long id){
        return todoRepository.findOne(id);
    }

}
