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

    private final BreachDSService service;

    public BreachRecordController(BreachDSService service) {
        this.service = service;
    }

    @PostMapping
    public BreachDSEntity create(@RequestBody BreachDSEntity breach) {
        return service.logBreach(breach);
    }

    @PutMapping("/{id}/resolve")
    public BreachDSEntity resolve(@PathVariable Long id) {
        return service.resolve(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachDSEntity> getByShipment(@PathVariable Long shipmentId) {
        return service.getByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public BreachDSEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<BreachDSEntity> getAll() {
        return service.getAll();
    }
}
