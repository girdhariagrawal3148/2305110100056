package com.example.notification_app_be.service;

import com.example.notification_app_be.dto.NotificationDTO;
import com.example.notification_app_be.util.NotificationComparator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class PriorityInboxService {

    private final NotificationComparator comparator =
            new NotificationComparator();

    public List<NotificationDTO> getTopTen(
            List<NotificationDTO> notifications) {

        PriorityQueue<NotificationDTO> heap =
                new PriorityQueue<>(comparator);

        for (NotificationDTO notification
                : notifications) {

            if (heap.size() < 10) {
                heap.offer(notification);
            }
            else if (
                    comparator.compare(
                            notification,
                            heap.peek()
                    ) > 0
            ) {
                heap.poll();
                heap.offer(notification);
            }
        }

        List<NotificationDTO> result =
                new ArrayList<>(heap);

        result.sort(
                comparator.reversed()
        );

        return result;
    }
}