package com.example.demo.service;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureLogService {

    private final TemperatureSensorLogRepository repo;

    public TemperatureLogService(TemperatureSensorLogRepository repo) {
        this.repo = repo;
    }

    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
        return repo.save(log);
    }

    public List<TemperatureSensorLog> getLogsByShipment(Long shipmentId) {
        return repo.findByShipmentId(shipmentId);
    }

    public TemperatureSensorLog getLogById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<TemperatureSensorLog> getAllLogs() {
        return repo.findAll();
    }
}
