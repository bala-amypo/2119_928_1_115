package com.example.demo.repository;

import com.example.demo.entity.AlertsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository
        extends JpaRepository<AlertsEntity, Long> {

    List<AlertsEntity> findByShipmentId(Long shipmentId);
}
