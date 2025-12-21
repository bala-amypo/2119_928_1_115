package com.example.demo.controller;

import com.example.demo.entity.BreachDSEntity;
import com.example.demo.service.BreachDSService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breaches")
public class BreachDSCTL {

    private final BreachDSService breachService;

    public BreachDSCTL(BreachDSService breachService) {
        this.breachService = breachService;
    }

    @PostMapping
    public BreachDSEntity createBreach(@RequestBody BreachDSEntity breach) {
        return breachService.logBreach(breach);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachDSEntity> getByShipment(@PathVariable Long shipmentId) {
        return breachService.getByShipment(shipmentId);
    }

    @PutMapping("/{id}/resolve")
    public BreachDSEntity resolve(@PathVariable Long id) {
        return breachService.resolve(id);
    }

    @GetMapping("/{id}")
    public BreachDSEntity getById(@PathVariable Long id) {
        return breachService.getById(id);
    }

    @GetMapping
    public List<BreachDSEntity> getAll() {
        return breachService.getAll();
    }
}
