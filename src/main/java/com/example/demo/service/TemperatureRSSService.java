package com.example.demo.service;

import com.example.demo.entity.TemperatureRSEntity;
import com.example.demo.repository.TemperatureRRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TemperatureRSService {

    private final TemperatureRRepository repository;

    public TemperatureRSService(TemperatureRRepository repository) {
        this.repository = repository;
    }

    public TemperatureRSEntity create(TemperatureRSEntity rule) {
        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new IllegalArgumentException("minTemp must be less than maxTemp");
        }
        return repository.save(rule);
    }

    public TemperatureRSEntity update(Long id, TemperatureRSEntity rule) {
        rule.setId(id);
        return repository.save(rule);
    }

    public List<TemperatureRSEntity> getActiveRules() {
        return repository.findByActiveTrue();
    }

    public TemperatureRSEntity getApplicableRule(String productType, LocalDate date) {
        return repository.findApplicableRule(productType, date);
    }

    public List<TemperatureRSEntity> getAll() {
        return repository.findAll();
    }
}
