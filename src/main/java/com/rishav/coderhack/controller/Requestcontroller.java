package com.rishav.coderhack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.rishav.coderhack.entity.User;
import com.rishav.coderhack.service.Userservice;


@RestController
@RequestMapping("/users")
public class Requestcontroller {

    @Autowired
    private Userservice service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable String userId) {
        return service.getUserById(userId);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public User updateScore(@PathVariable String userId, @RequestBody int score) {
        return service.updateScore(userId, score);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable String userId) {
        return service.deleteUser(userId);
    }
}
