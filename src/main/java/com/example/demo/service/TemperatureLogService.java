package com.example.demo.service;

import com.example.demo.entity.TemperatureLSEntity;
import com.example.demo.repository.TemperatureSLRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureLogService {

    private final TemperatureSLRepository repository;

    public TemperatureLogService(TemperatureSLRepository repository) {
        this.repository = repository;
    }

    public TemperatureLSEntity recordLog(TemperatureLSEntity log) {
        return repository.save(log);
    }

    public List<TemperatureLSEntity> getLogsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public List<TemperatureLSEntity> getAllLogs() {
        return repository.findAll();
    }
}
