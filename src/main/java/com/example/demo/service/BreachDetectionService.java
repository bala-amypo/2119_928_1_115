package com.example.demo.service;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachDetectionService {

    private final BreachRecordRepository repo;

    public BreachDetectionService(BreachRecordRepository repo) {
        this.repo = repo;
    }

    public BreachRecord logBreach(BreachRecord breach) {
        return repo.save(breach);
    }

    public BreachRecord resolve(Long id) {
        BreachRecord breach = repo.findById(id).orElse(null);
        if (breach != null) {
            breach.setResolved(true);
            return repo.save(breach);
        }
        return null;
    }

    public List<BreachRecord> getByShipment(Long shipmentId) {
        return repo.findByShipmentId(shipmentId);
    }

    public BreachRecord getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<BreachRecord> getAll() {
        return repo.findAll();
    }
}
