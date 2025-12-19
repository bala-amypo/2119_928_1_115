package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Breach;
import com.example.demo.service.BreachService;

@RestController
@RequestMapping("/breach")
public class BreachController {

    @Autowired
    private BreachService breachService;

    // CREATE
    @PostMapping("/add")
    public Breach addBreach(@RequestBody Breach breach) {
        return breachService.saveBreach(breach);
    }

    // READ ALL
    @GetMapping("/all")
    public List<Breach> getAllBreaches() {
        return breachService.getAllBreaches();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Breach getBreachById(@PathVariable int id) {
        return breachService.getBreachById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Breach updateBreach(
            @PathVariable int id,
            @RequestBody Breach breach) {
        return breachService.updateBreach(id, breach);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteBreach(@PathVariable int id) {
        breachService.deleteBreach(id);
        return "Breach deleted succes
