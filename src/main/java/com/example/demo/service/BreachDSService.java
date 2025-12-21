package com.example.demo.service;

import com.example.demo.entity.BreachDSEntity;
import com.example.demo.repository.BreachRRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachDSService {

    private final BreachRRepository repository;

    public BreachDSService(BreachRRepository repository) {
        this.repository = repository;
    }

    public BreachDSEntity logBreach(BreachDSEntity breach) {
        return repository.save(breach);
    }

    public List<BreachDSEntity> getByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public BreachDSEntity resolve(Long id) {
        BreachDSEntity breach = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Breach not found"));

        breach.setResolved(true);
        return repository.save(breach);
    }

    public BreachDSEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Breach not found"));
    }

    public List<BreachDSEntity> getAll() {
        return repository.findAll();
    }
}
