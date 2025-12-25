package com.example.demo.service;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private final AlertRecordRepository repo;

    public AlertService(AlertRecordRepository repo) {
        this.repo = repo;
    }

    public AlertRecord triggerAlert(AlertRecord alert) {
        return repo.save(alert);
    }

    public AlertRecord acknowledgeAlert(Long id) {
        AlertRecord alert = repo.findById(id).orElse(null);
        if (alert != null) {
            alert.setAcknowledged(true);
            return repo.save(alert);
        }
        return null;
    }

    public List<AlertRecord> getAlertsByShipment(Long shipmentId) {
        return repo.findByShipmentId(shipmentId);
    }

    public AlertRecord getAlertById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<AlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}
