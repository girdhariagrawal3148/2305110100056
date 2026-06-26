package com.example.vehicle_scheduler_be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ScheduleResponse {

    private String depotId;
    private int totalImpact;
    private List<String> selectedTaskIds;
}