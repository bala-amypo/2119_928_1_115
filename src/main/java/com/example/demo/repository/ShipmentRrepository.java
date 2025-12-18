package com.example.demo.repository;

import com.example.demo.entity.ShipmentRSEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository
        extends JpaRepository<ShipmentRSEntity, Long> {

    ShipmentRSEntity findByShipmentCode(String shipmentCode);
}
