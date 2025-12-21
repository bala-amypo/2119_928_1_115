package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperature_logs")
public class TemperatureLSEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "shipment_id", nullable = false)
    private ShipmentRSEntity shipment;


    private Long shipmentId;
    private Double temperatureValue;
    private String location;
    private LocalDateTime recordedAt;

    @PrePersist
    void onCreate() {
        this.recordedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getShipmentId() { return shipmentId; }
    public Double getTemperatureValue() { return temperatureValue; }
    public String getLocation() { return location; }
    public LocalDateTime getRecordedAt() { return recordedAt; }

    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }
    public void setTemperatureValue(Double temperatureValue) { this.temperatureValue = temperatureValue; }
    public void setLocation(String location) { this.location = location; }
}
