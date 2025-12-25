package com.example.demo.service;

import com.example.demo.entity.BreachDSEntity;
import com.example.demo.repository.BreachRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachDetectionService {

    private final BreachRecordRepository repository;

    public BreachDetectionService(BreachRecordRepository repository) {
        this.repository = repository;
    }

    public BreachDSEntity logBreach(BreachDSEntity breach) {
        return repository.save(breach);
    }

    public List<BreachDSEntity> getBreachesByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public BreachDSEntity resolveBreach(Long id) {
        BreachDSEntity b = repository.findById(id).orElseThrow();
        b.setResolved(true);
        return repository.save(b);
    }

    public List<BreachDSEntity> getAllBreaches() {
        return repository.findAll();
    }
}
