package com.maverick.harsha.todo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Harsha on 2/22/2017.
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
