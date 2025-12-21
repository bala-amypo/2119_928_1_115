package com.example.demo.repository;

import com.example.demo.entity.BreachDSEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreachRRepository
        extends JpaRepository<BreachDSEntity, Long> {

    List<BreachDSEntity> findByShipment_Id(Long shipmentId);
}

