package com.maverick.harsha;

import com.maverick.harsha.todo.Todo;
import com.maverick.harsha.todo.TodoRepository;
import com.maverick.harsha.user.User;
import com.maverick.harsha.user.UserRepository;
import com.maverick.harsha.user.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		userRepository.save(new User("mavharsha", "mamilla", "harsha"));
        userRepository.save(new User("username", "firstname", "lastname"));

        todoRepository.save(new Todo(userService.findUser(new Long(1)), "todo1", "testdes", TodoStatus.DONE, new DateTime().toDateTime(), new DateTime().toDateTime().plusWeeks(1)));
		todoRepository.save(new Todo(userService.findUser(new Long(1)), "todo2", "testdes2", TodoStatus.PENDING, new DateTime().toDateTime(), new DateTime().toDateTime().plusWeeks(1)));

    }
}
