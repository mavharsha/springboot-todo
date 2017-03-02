package com.maverick.harsha.todo;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Harsha on 2/22/2017.
 */

@Controller
@RequestMapping("/todos")
@ExposesResourceFor(Todo.class)
public class TodoController {

    private TodoService todoService;
    private final EntityLinks entityLinks;

    public TodoController(TodoService todoService, EntityLinks entityLinks){
        this.todoService = todoService;
        this.entityLinks = entityLinks;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Resources<Todo>> getAllTodos(){
        Resources<Todo> resources = new Resources<Todo>(
                this.todoService.findAll());
        resources.add(this.entityLinks.linkToCollectionResource(Todo.class));
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Resource<Todo>> getTodo(@PathVariable Long id){
        Resource<Todo> resource = new Resource<Todo>(
                this.todoService.findOneById(id));
        resource.add(this.entityLinks.linkToSingleResource(Todo.class, id));
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
