package com.nmb.analyticsservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    @KafkaListener(topics = {"new-orders", "payment-events"}, groupId = "analytics-service-group")
    public void processAnalytics(String message) {
        // In a real-world scenario, this would process and store analytics data
        System.out.println("Processing analytics: " + message);
    }
}
