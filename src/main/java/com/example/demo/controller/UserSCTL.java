package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserSCTL {

    private final UserService userService;

    public UserSCTL(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
