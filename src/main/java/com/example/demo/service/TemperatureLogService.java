package com.example.demo.service;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureLogService {

    private final TemperatureSensorLogRepository repository;

    // REQUIRED constructor signature
    public TemperatureLogService(TemperatureSensorLogRepository repository) {
        this.repository = repository;
    }

    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
        return repository.save(log);
    }

    public List<TemperatureSensorLog> getLogsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public TemperatureSensorLog getLogById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<TemperatureSensorLog> getAllLogs() {
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
  return repository.findAll();
    }
}
