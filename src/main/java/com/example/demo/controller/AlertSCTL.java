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

    public AlertsCTL(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/")
    public AlertsEntity triggerAlert(@RequestBody AlertsEntity alert) {
        return alertService.triggerAlert(alert);
    }

    @PutMapping("/{id}/acknowledge")
    public AlertsEntity acknowledgeAlert(@PathVariable Long id) {
        return alertService.acknowledgeAlert(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertsEntity> getAlertsByShipment(@PathVariable Long shipmentId) {
        return alertService.getAlertsByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public AlertsEntity getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    @GetMapping("/")
    public List<AlertsEntity> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
