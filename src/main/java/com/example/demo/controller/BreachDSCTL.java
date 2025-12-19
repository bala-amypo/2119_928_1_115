package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BreachDSEntity;
import com.example.demo.service.BreachDSService;

@RestController
@RequestMapping("/api/breaches")
public class BreachDSCTL {

    private final BreachDSService breachDSService;

    public BreachDSCTL(BreachDSService breachDSService) {
        this.breachDSService = breachDSService;
    }

    @PostMapping
    public BreachDSEntity create(@RequestBody BreachDSEntity breach) {
        return breachDSService.save(breach);
    }

    @GetMapping
    public List<BreachDSEntity> getAll() {
        return breachDSService.getAll();
    }

    @GetMapping("/{id}")
    public BreachDSEntity getById(@PathVariable Long id) {
        return breachDSService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        breachDSService.delete(id);
        return "Breach deleted successfully";
    }
}
