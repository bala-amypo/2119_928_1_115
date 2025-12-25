package com.example.demo.service;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.repository.ShipmentRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentRecordService {

    private final ShipmentRecordRepository repository;

    public ShipmentRecordService(ShipmentRecordRepository repository) {
        this.repository = repository;
    }

    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return repository.save(shipment);
    }

    public ShipmentRecord getShipmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
    }

    public ShipmentRecord getShipmentByCode(String code) {
        return repository.findByShipmentCode(code);
    }

    public List<ShipmentRecord> getAllShipments() {
        return repository.findAll();
    }

    public ShipmentRecord updateStatus(Long id, String status) {
        ShipmentRecord shipment = getShipmentById(id);
        shipment.setStatus(status);
        return repository.save(shipment);
    }
}
