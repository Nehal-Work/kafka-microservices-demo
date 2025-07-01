package com.accelgrowth.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String TOPIC = "order-topic";

    public void sendOrder(String order) {
        kafkaTemplate.send(TOPIC, order);
    }
}
