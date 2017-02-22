package com.maverick.harsha.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        ArrayList<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(user -> userList.add(user));
        return userList;
    }
}
