package com.example.vehicle_scheduler_be.controller;

import com.example.vehicle_scheduler_be.client.DepotClient;
import com.example.vehicle_scheduler_be.dto.Depot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepotController {

    private final DepotClient depotClient;

    public DepotController(DepotClient depotClient) {
        this.depotClient = depotClient;
    }

    @GetMapping("/test/depots")
    public List<Depot> getDepots() {
        return depotClient.getDepots();
    }
}