package com.docker.docker.controllers;

import com.docker.docker.model.User;
import com.docker.docker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerMessageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/messages")
    public String getMessage() {
        System.out.println("ok");
        return "Hello from Docker!";
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody User user) {
        System.out.println("ok");
        User registeredUser = userRepository.save(user);

        return ResponseEntity.ok(registeredUser);
    }
}
