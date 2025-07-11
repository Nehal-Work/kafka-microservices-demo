package com.accelgrowth.inventory_service.service;

import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.accelgrowth.inventory_service.dto.OrderRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerService {
	

	 private final ObjectMapper objectMapper = new ObjectMapper();

	    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
	    public void consume(String orderJson) {
	        try {
	            OrderRequest order = objectMapper.readValue(orderJson, OrderRequest.class);
	            System.out.println("Received order in inventory-service: " + order);

	            String item = order.getItem();
	            int stock = getStock(item);
	            System.out.println("Stock for " + item + ": " + stock);

	        } catch (Exception e) {
	            System.err.println("Failed to parse order JSON: " + orderJson);
	            e.printStackTrace();
	        }
	    }    
    
    @Cacheable(value = "itemStock", key = "#itemName")
    public int getStock(String itemName) {
        System.out.println("Fetching stock from database for item: " + itemName);
        // simulate DB call
        return new Random().nextInt(100); // For demo purpose
    }
}
