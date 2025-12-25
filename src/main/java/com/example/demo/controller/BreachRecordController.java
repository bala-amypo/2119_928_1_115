package com.example.demo.controller;

import com.example.demo.entity.BreachDSEntity;
import com.example.demo.service.BreachDSService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breaches")
public class BreachRecordController {

    private final BreachDetectionService service;

    public BreachRecordController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public BreachRecord create(@RequestBody BreachRecord breach) {
        return service.logBreach(breach);
    }

    @PutMapping("/{id}/resolve")
    public BreachRecord resolve(@PathVariable Long id) {
        return service.resolve(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachRecord> getByShipment(@PathVariable Long shipmentId) {
        return service.getByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public BreachRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<BreachRecord> getAll() {
        return service.getAll();
    }
}
