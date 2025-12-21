package com.example.demo.service;

import com.example.demo.entity.AlertsEntity;
import com.example.demo.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private final AlertRepository repository;

    public AlertService(AlertRepository repository) {
        this.repository = repository;
    }

    public AlertsEntity triggerAlert(AlertsEntity alert) {
        return repository.save(alert);
    }

    public AlertsEntity acknowledgeAlert(Long id) {
        AlertsEntity alert = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Alert not found"));

        alert.setAcknowledged(true);
        return repository.save(alert);
    }

    public List<AlertsEntity> getAlertsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public AlertsEntity getAlertById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Alert not found"));
    }

    public List<AlertsEntity> getAllAlerts() {
        return repository.findAll();
    }
}
