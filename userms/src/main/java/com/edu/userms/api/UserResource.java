package com.edu.userms.api;

import com.edu.userms.model.User;
import com.edu.userms.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserRepo repo;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return repo.findAll();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        User newUser = repo.save(user);
        return newUser;
    }
}
