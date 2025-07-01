package com.accelgrowth.inventory_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void consume(String order) {
        System.out.println("Received order in inventory-service: " + order);
        // Add inventory update logic here
    }
}
