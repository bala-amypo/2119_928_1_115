package com.example.demo.controller;

import com.example.demo.entity.ShipmentRSEntity;
import com.example.demo.service.ShipmentRService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@Tag(name = "Shipments")
public class ShipmentRSCTL {

    private final ShipmentRService service;

    public ShipmentRSCTL(ShipmentRService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ShipmentRSEntity createShipment(@RequestBody ShipmentRSEntity shipment) {
        return service.create(shipment);
    }

    @GetMapping("/")
    public List<ShipmentRSEntity> getAll() {
        return service.getAll();
    }
}
