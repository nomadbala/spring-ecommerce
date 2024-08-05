package com.nmb.notificationservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @KafkaListener(topics = {"new-orders", "payment-events"}, groupId = "notification-service-group")
    public void processNotification(String message) {
        System.out.println("Sending notification: " + message);
    }
}
