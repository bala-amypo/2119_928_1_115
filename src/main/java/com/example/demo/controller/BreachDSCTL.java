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

    // CREATE breach
    @PostMapping
    public BreachDSEntity createBreach(@RequestBody BreachDSEntity breach) {
        return breachDSService.logBreach(breach);
    }

    // GET all breaches
    @GetMapping
    public List<BreachDSEntity> getAllBreaches() {
        return breachDSService.getAll();
    }

    // GET breaches by shipmentId
    @GetMapping("/shipment/{shipmentId}")
    public List<BreachDSEntity> getByShipment(@PathVariable Long shipmentId) {
        return breachDSService.getByShipment(shipmentId);
    }

    // RESOLVE breach
    @PutMapping("/resolve/{id}")
    public BreachDSEntity resolveBreach(@PathVariable Long id) {
        return breachDSService.resolve(id);
    }
}
