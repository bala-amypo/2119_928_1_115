package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    TemperatureRule findByProductType(String productType);
}
