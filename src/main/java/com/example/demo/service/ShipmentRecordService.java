package com.example.demo.service;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.repository.ShipmentRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentRecordService {

    private final ShipmentRecordRepository repo;

    public ShipmentRecordService(ShipmentRecordRepository repo) {
        this.repo = repo;
    }

    public ShipmentRecord create(ShipmentRecord shipment) {
        return repo.save(shipment);
    }

    public ShipmentRecord updateStatus(Long id, String status) {
        ShipmentRecord shipment = repo.findById(id).orElse(null);
        if (shipment != null) {
            shipment.setStatus(status);
            return repo.save(shipment);
        }
        return null;
    }

    public ShipmentRecord getByCode(String code) {
        return repo.findByCode(code);
    }

    public ShipmentRecord getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<ShipmentRecord> getAll() {
        return repo.findAll();
    }
}
