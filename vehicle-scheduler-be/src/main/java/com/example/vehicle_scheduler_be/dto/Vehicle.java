package com.example.vehicle_scheduler_be.dto;

import lombok.Data;

@Data
public class Vehicle {

    private String vehicleId;
    private String taskId;
    private int estimatedHours;
    private int impactScore;
}