package com.example.notification_app_be.util;

import com.example.notification_app_be.dto.NotificationDTO;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;

public class NotificationComparator
        implements Comparator<NotificationDTO> {

    private static final Map<String, Integer> WEIGHTS =
            Map.of(
                    "Placement", 3,
                    "Result", 2,
                    "Event", 1
            );

    @Override
    public int compare(
            NotificationDTO a,
            NotificationDTO b) {

        int wa =
                WEIGHTS.getOrDefault(
                        a.getType(),
                        0
                );

        int wb =
                WEIGHTS.getOrDefault(
                        b.getType(),
                        0
                );

        if (wa != wb) {
            return wa - wb;
        }

        return LocalDateTime
                .parse(a.getTimestamp())
                .compareTo(
                        LocalDateTime.parse(
                                b.getTimestamp()
                        )
                );
    }
}