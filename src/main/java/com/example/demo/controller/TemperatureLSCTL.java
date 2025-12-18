package com.example.demo.controller;

import com.example.demo.entity.TemperatureLSEntity;
import com.example.demo.service.TemperatureRSSService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Temperature Logs")
public class TemperatureLSCTL {

    private final TemperatureRSSService service;

    public TemperatureLSCTL(TemperatureRSSService service) {
        this.service = service;
    }

    @PostMapping("/")
    public TemperatureLSEntity recordLog(@RequestBody TemperatureLSEntity log) {
        return service.record(log);
    }
}
