package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breaches")
public class BreachRecordController {

    private final BreachDetectionService service;

    public BreachRecordController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public BreachRecord logBreach(@RequestBody BreachRecord breach) {
        return service.logBreach(breach);
    }

    @PutMapping("/{id}/resolve")
    public BreachRecord resolveBreach(@PathVariable Long id) {
        return service.resolveBreach(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachRecord> getBreachesByShipment(@PathVariable Long shipmentId) {
        return service.getBreachesByShipment(shipmentId);
    }
}
