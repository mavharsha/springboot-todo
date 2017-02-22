package com.maverick.harsha;

import com.maverick.harsha.user.User;
import com.maverick.harsha.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		userRepository.save(new User("mavharsha", "mamilla", "harsha"));
        userRepository.save(new User("username", "firstname", "lastname"));

    }
}
