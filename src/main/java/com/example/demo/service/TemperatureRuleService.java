package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureRuleService {

    private final TemperatureRuleRepository repository;

    public TemperatureRuleService(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    public TemperatureRule createRule(TemperatureRule rule) {
        return repository.save(rule);
    }

    public List<TemperatureRule> getAllRules() {
        return repository.findAll();
    }
}
