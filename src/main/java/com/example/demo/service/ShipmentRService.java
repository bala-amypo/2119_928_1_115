package com.example.demo.service;

import com.example.demo.entity.ShipmentRSEntity;
import com.example.demo.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentRService {

    private final ShipmentRepository repository;

    public ShipmentRService(ShipmentRepository repository) {
        this.repository = repository;
    }

    public ShipmentRSEntity create(ShipmentRSEntity shipment) {
        return repository.save(shipment);
    }

    public ShipmentRSEntity getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ShipmentRSEntity getByCode(String code) {
        return repository.findByShipmentCode(code);
    }

    public List<ShipmentRSEntity> getAll() {
        return repository.findAll();
    }

    public ShipmentRSEntity updateStatus(Long id, String status) {
        ShipmentRSEntity shipment = getById(id);
        if (shipment != null) {
            shipment.setStatus(status);
            return repository.save(shipment);
        }
        return null;
    }
}
