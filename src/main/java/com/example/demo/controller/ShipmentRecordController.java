package com.example.demo.controller;

import com.example.demo.entity.ShipmentRSEntity;
import com.example.demo.service.ShipmentRService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@Tag(name = "Shipments")
public class ShipmentRecordController {

    private final ShipmentRService service;

    public ShipmentRecordController(ShipmentRService service) {
        this.service = service;
    }

    @PostMapping
    public ShipmentRSEntity createShipment(@RequestBody ShipmentRSEntity shipment) {
        return service.create(shipment);
    }

    @PutMapping("/{id}/status")
    public ShipmentRSEntity updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/code/{code}")
    public ShipmentRSEntity getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }

    @GetMapping("/{id}")
    public ShipmentRSEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ShipmentRSEntity> getAll() {
        return service.getAll();
    }
}
