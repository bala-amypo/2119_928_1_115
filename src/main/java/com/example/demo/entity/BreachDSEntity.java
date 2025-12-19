package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "breaches")
public class BreachDSEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Double breachValue;
    private String severity;
    private Boolean resolved;
    private LocalDateTime detectedAt;

    @PrePersist
    void onCreate() {
        this.detectedAt = LocalDateTime.now();
        this.resolved = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Double getBreachValue() {
        return breachValue;
    }

    public void setBreachValue(Double breachValue) {
        this.breachValue = breachValue;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }
}
