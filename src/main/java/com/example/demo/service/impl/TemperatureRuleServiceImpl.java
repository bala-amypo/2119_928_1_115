package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository repo;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        rule.validate(); // 🔥 REQUIRED FOR TEST
        return repo.save(rule);
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public Optional<TemperatureRule> getRuleForProduct(String product, LocalDate date) {
        return repo.findApplicableRule(product, date);
    }
}
