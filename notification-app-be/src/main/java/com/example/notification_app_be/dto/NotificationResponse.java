package com.example.notification_app_be.dto;

import lombok.Data;

import java.util.List;

@Data
public class NotificationResponse {

    private List<NotificationDTO> notifications;
}