package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCTL { 

    @GetMapping("/")
    public String home() {
        return "Transport Pro API is running";
    }
}
