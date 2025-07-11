package com.accelgrowth.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.accelgrowth.order_service.dto.OrderRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaProducerService {
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendOrder(OrderRequest orderRequest) {
        try {
            String jsonOrder = objectMapper.writeValueAsString(orderRequest);
            kafkaTemplate.send("order-topic", jsonOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
