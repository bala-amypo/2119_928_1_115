package com.example.demo.controller;

import com.example.demo.entity.AlertsEntity;
import com.example.demo.service.AlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts")
public class AlertsCTL {

    private final AlertService alertService;

    public AlertRecordController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public AlertsEntity triggerAlert(@RequestBody AlertsEntity alert) {
        return alertService.triggerAlert(alert);
    }

    @PutMapping("/{id}/acknowledge")
    public AlertsEntity acknowledge(@PathVariable Long id) {
        return alertService.acknowledgeAlert(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertsEntity> getByShipment(@PathVariable Long shipmentId) {
        return alertService.getAlertsByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public AlertsEntity getById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    @GetMapping
    public List<AlertsEntity> getAll() {
        return alertService.getAllAlerts();
    }
}
