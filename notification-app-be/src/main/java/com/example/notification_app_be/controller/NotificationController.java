package com.example.notification_app_be.controller;

import com.example.notification_app_be.dto.NotificationDTO;
import com.example.notification_app_be.dto.NotificationResponse;
import com.example.notification_app_be.service.PriorityInboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final RestTemplate restTemplate;
    private final PriorityInboxService service;

    private static final String URL =
            "http://4.224.186.213/evaluation-service/notifications";

    @GetMapping("/priority-notifications")
    public List<NotificationDTO> getTopNotifications() {

        NotificationResponse response =
                restTemplate.getForObject(
                        URL,
                        NotificationResponse.class
                );

        if (response == null ||
                response.getNotifications() == null) {
            return List.of();
        }

        return service.getTopTen(
                response.getNotifications()
        );
    }
}