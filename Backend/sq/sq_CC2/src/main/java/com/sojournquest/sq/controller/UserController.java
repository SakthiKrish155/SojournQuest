package com.sojournquest.sq.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sojournquest.sq.model.User;
import com.sojournquest.sq.service.UserService;

@RestController
@RequestMapping("/api/sojournquest")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        try {
            userService.signUp(user);
            return ResponseEntity.ok().body("Signed up successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody User user) {
        User authenticatedUser = userService.signIn(user.getFullname(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with email " + email + " not found");
        }
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<String> updateUserByEmail(@PathVariable String email, @RequestBody User user) {
        User updatedUser = userService.updateUserByEmail(email, user);
        if (updatedUser != null) {
            return ResponseEntity.ok("User details updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
        userService.deleteUserByEmail(email);
        return ResponseEntity.ok("User deleted successfully");
    }

}
    
