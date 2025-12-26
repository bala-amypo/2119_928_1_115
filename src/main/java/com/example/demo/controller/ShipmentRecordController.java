package com.example.demo.controller;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentRecordController {

    private final ShipmentRecordService service;

    public ShipmentRecordController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ShipmentRecord createShipment(@RequestBody ShipmentRecord shipment) {
        return service.createShipment(shipment);
    }

    @PutMapping("/{id}/status")
    public ShipmentRecord updateShipmentStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateShipmentStatus(id, status);
    }

    @GetMapping("/code/{code}")
    public ShipmentRecord getShipmentByCode(@PathVariable String code) {
        return service.getShipmentByCode(code).orElse(null);
    }

    @GetMapping
    public List<ShipmentRecord> getAllShipments() {
        return service.getAllShipments();
    }
}
