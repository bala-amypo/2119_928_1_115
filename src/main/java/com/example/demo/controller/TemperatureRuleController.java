package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureRule createRule(@RequestBody TemperatureRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return service.getActiveRules();
    }
}