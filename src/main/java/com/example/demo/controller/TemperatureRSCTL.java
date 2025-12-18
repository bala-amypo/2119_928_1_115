package com.example.demo.controller;

import com.example.demo.entity.TemperatureRSEntity;
import com.example.demo.service.TemperatureRSService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Temperature Rules")
public class TemperatureRSCTL {

    private final TemperatureRSService service;

    public TemperatureRSCTL(TemperatureRSService service) {
        this.service = service;
    }

    @PostMapping("/")
    public TemperatureRSEntity createRule(@RequestBody TemperatureRSEntity rule) {
        return service.create(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRSEntity> getActiveRules() {
        return service.getActiveRules();
    }
}
