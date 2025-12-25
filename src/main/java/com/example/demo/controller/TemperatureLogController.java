package com.example.demo.controller;

import com.example.demo.entity.TemperatureLSEntity;
import com.example.demo.service.TemperatureLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Temperature Logs")
public class TemperatureLogController {

    private final TemperatureLogService service;

    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureLSEntity recordLog(@RequestBody TemperatureLSEntity log) {
        return service.recordLog(log);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureLSEntity> getByShipment(@PathVariable Long shipmentId) {
        return service.getLogsByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public TemperatureLSEntity getById(@PathVariable Long id) {
        return service.getLogById(id);
    }

    @GetMapping
    public List<TemperatureLSEntity> getAll() {
        return service.getAllLogs();
    }
}
