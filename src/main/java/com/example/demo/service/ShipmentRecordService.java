package com.example.demo.service;

import com.example.demo.entity.ShipmentRSEntity;
import com.example.demo.repository.ShipmentRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentRecordService {

    private final ShipmentRecordRepository repository;

    public ShipmentRecordService(ShipmentRecordRepository repository) {
        this.repository = repository;
    }

    public ShipmentRSEntity createShipment(ShipmentRSEntity shipment) {
        return repository.save(shipment);
    }

    public ShipmentRSEntity updateShipmentStatus(Long id, String status) {
        ShipmentRSEntity s = repository.findById(id).orElseThrow();
        s.setStatus(status);
        return repository.save(s);
    }

    public ShipmentRSEntity getShipmentByCode(String code) {
        return repository.findByShipmentCode(code);
    }

    public ShipmentRSEntity getShipmentById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<ShipmentRSEntity> getAllShipments() {
        return repository.findAll();
    }
}
