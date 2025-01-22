package com.carapp.carapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carapp.carapp.model.User;
import com.carapp.carapp.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping("/All")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // Create a new user (POST /Users)
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Update an existing user
    @PutMapping("/Modify/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody User user) {
        try {
            userService.modifyById(id, user);
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update user");
        }
    }

    // Delete a user
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<Optional<User>> loginUser(@RequestBody User user) {
        Optional<User> existingUserOpt = userService.findUserByEmail(user.getEmail());

        if (existingUserOpt.isPresent() && existingUserOpt.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok().body(existingUserOpt);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(existingUserOpt);
        }
    }
}
