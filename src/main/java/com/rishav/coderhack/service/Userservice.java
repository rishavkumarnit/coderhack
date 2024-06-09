package com.rishav.coderhack.service;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rishav.coderhack.entity.User;
import com.rishav.coderhack.exception.*;
import com.rishav.coderhack.repository.Userrepo;


@Service
public class Userservice {

    @Autowired
    private Userrepo repository;

    public User addUser(User user) {
        user.setScore(0);
        user.setBadges(new ArrayList<>());
        return repository.save(user);
    }

    public List<User> findAllUsers() {
        return repository.findAll().stream()
                .sorted((u1, u2) -> Integer.compare(u2.getScore(), u1.getScore()))
                .collect(Collectors.toList());
    }

    public User getUserById(String userId) {
        Optional<User> user = repository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new userException("User not found");
        }
    }

    public User updateScore(String userId, int score) {
        User user = getUserById(userId);
        if (score < 0 || score > 100) {
            throw new scoreException("Score between 0 and 100 is allowed");
        }
        user.setScore(score);
        updateBadges(user);
        return repository.save(user);
    }

    private void updateBadges(User user) {
        user.getBadges().clear();
        if (user.getScore() >= 1 && user.getScore() < 30) {
            user.getBadges().add("Code Ninja");
        } else if (user.getScore() >= 30 && user.getScore() < 60) {
            user.getBadges().add("Code Ninja");
            user.getBadges().add("Code Champ");
        } else if (user.getScore() >= 60 && user.getScore() <= 100) {
            user.getBadges().add("Code Ninja");
            user.getBadges().add("Code Champ");
            user.getBadges().add("Code Master");
        }
    }

    public String deleteUser(String userId) {
        User user = getUserById(userId);
        repository.deleteById(userId);
        return "User " + userId + " deleted from the database";
    }


}