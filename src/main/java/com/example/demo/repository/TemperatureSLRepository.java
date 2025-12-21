package com.example.demo.repository;

import com.example.demo.entity.TemperatureLSEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemperatureSLRepository
        extends JpaRepository<TemperatureLSEntity, Long> {

    List<TemperatureLSEntity> findByShipmentId(Long shipmentId);
}
