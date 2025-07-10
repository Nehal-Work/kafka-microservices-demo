package com.accelgrowth.inventory_service.service;

import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void consume(String order) {
        System.out.println("Received order in inventory-service: " + order);
        // Add inventory update logic here
        String item = "Laptop"; // Normally extract from order
        int stock = getStock(item);
        System.out.println("Stock for " + item + ": " + stock);
    }
    
    
    @Cacheable(value = "itemStock", key = "#itemName")
    public int getStock(String itemName) {
        System.out.println("Fetching stock from database for item: " + itemName);
        // simulate DB call
        return new Random().nextInt(100); // For demo purpose
    }
}
