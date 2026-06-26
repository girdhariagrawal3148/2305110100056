package com.example.notification_app_be.dto;

import lombok.Data;

@Data
public class NotificationDTO {

    private String ID;
    private String Type;
    private String Message;
    private String Timestamp;
}