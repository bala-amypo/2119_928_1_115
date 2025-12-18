package com.example.demo.service;

import com.example.demo.entity.TemperatureLSEntity;
import com.example.demo.repository.TemperatureSLRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureRSSService {

    private final TemperatureSLRepository repository;

    public TemperatureRSSService(TemperatureSLRepository repository) {
        this.repository = repository;
    }

    public TemperatureLSEntity record(TemperatureLSEntity log) {
        return repository.save(log);
    }

    public List<TemperatureLSEntity> getByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public TemperatureLSEntity getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<TemperatureLSEntity> getAll() {
        return repository.findAll();
    }
}
