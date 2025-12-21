package com.example.demo.service;

import com.example.demo.entity.TemperatureLSEntity;
import com.example.demo.repository.TemperatureSLRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class @Service
public class TemperatureLogService {

    private final TemperatureSLRepository repository;
    private final ShipmentRepository shipmentRepository;

    public TemperatureLogService(
            TemperatureSLRepository repository,
            ShipmentRepository shipmentRepository) {
        this.repository = repository;
        this.shipmentRepository = shipmentRepository;
    }

    public TemperatureLSEntity recordLog(
            TemperatureLSEntity log,
            Long shipmentId) {

        ShipmentRSEntity shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new RuntimeException("Shipment not found"));

        log.setShipment(shipment);
        return repository.save(log);
    }

    public List<TemperatureLSEntity> getLogsByShipment(Long shipmentId) {
        return repository.findByShipment_Id(shipmentId);
    }

    public List<TemperatureLSEntity> getAllLogs() {
        return repository.findAll();
    }
}
TemperatureLogService {

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
