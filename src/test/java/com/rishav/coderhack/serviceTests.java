package com.rishav.coderhack;

import com.rishav.coderhack.service.*;
import com.rishav.coderhack.entity.*;
import com.rishav.coderhack.repository.*;
import com.rishav.coderhack.exception.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class serviceTests {

    @Autowired
    private Userservice service;

    @Autowired
    private Userrepo repository;

    @Test
    void testAddUser() {
        User user = new User("1", "testuser1");
        User savedUser = service.addUser(user);
        assertNotNull(savedUser);
        assertEquals(0, savedUser.getScore());
        assertTrue(savedUser.getBadges().isEmpty());
    }

    @Test
    void testUpdateUserScore() {
        User user = new User("2", "testuser2");
        service.addUser(user);
        User updatedUser = service.updateScore("2", 25);
        assertEquals(25, updatedUser.getScore());
        assertTrue(updatedUser.getBadges().contains("Code Ninja"));
    }

    @Test
    void testGetUserById() {
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