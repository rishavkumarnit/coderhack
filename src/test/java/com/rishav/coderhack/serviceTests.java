package com.rishav.coderhack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rishav.coderhack.entity.User;
import com.rishav.coderhack.exception.userException;
import com.rishav.coderhack.repository.Userrepo;
import com.rishav.coderhack.service.Userservice;


@SpringBootTest
class serviceTests {

    @Autowired
    private Userservice service;

    @Autowired
    private Userrepo repository;

    @Test
    void testAddUser() {
        service.deleteUser("1"); // First delete the user id if the documnet already contains the user id
        User user = new User("1", "testuser1");
        User savedUser = service.addUser(user);
        assertNotNull(savedUser);
        assertEquals(0, savedUser.getScore());
        assertTrue(savedUser.getBadges().isEmpty());
    }

    @Test
    void testUpdateUserScore() {
        service.deleteUser("2"); // First delete the user id if the documnet already contains the user id
        User user = new User("2", "testuser2");
        service.addUser(user);
        User updatedUser = service.updateScore("2", 25);
        assertEquals(25, updatedUser.getScore());
        assertTrue(updatedUser.getBadges().contains("Code Ninja"));
    }

    @Test
    void testGetUserById() {
        service.deleteUser("3"); // First delete the user id if the documnet already contains the user id
        User user = new User("3", "testuser3");
        service.addUser(user);
        User foundUser = service.getUserById("3");
        assertNotNull(foundUser);
        assertEquals("3", foundUser.getUserId());
    }

    @Test
    void testGetUserById_NotFound() {
        Exception exception = assertThrows(userException.class, () -> {
            service.getUserById("4");
        });

        String expectedMessage = "User not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDeleteUser() {
        User user = new User("5", "testuser5");
        service.addUser(user);
        service.deleteUser("5");
        assertThrows(userException.class, () -> {
            service.getUserById("5");
        });
    }

}