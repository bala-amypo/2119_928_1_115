package com.example.demo.repository;

import com.example.demo.entity.TemperatureRSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TemperatureRRepository
        extends JpaRepository<TemperatureRSEntity, Long> {

    List<TemperatureRSEntity> findByActiveTrue();

    @Query("""
        SELECT r FROM TemperatureRSEntity r
        WHERE r.productType = :productType
          AND :date BETWEEN r.effectiveFrom AND r.effectiveTo
          AND r.active = true
    """)
    TemperatureRSEntity findApplicableRule(String productType, LocalDate date);
}
