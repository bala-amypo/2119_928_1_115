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

    private final ShipmentRecordService service;

    public ShipmentRecordController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ShipmentRecord createShipment(@RequestBody ShipmentRecord shipment) {
        return service.create(shipment);
    }

    @PutMapping("/{id}/status")
    public ShipmentRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/code/{code}")
    public ShipmentRecord getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }

    @GetMapping("/{id}")
    public ShipmentRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ShipmentRecord> getAll() {
        return service.getAll();
    }
}
