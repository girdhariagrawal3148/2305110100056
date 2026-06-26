package com.example.vehicle_scheduler_be.client;

import com.example.vehicle_scheduler_be.dto.Depot;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class DepotClient {

    private final RestClient restClient;

    public DepotClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Depot> getDepots() {
        return restClient.get()
                .uri("/depots")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Depot>>() {});
    }
}