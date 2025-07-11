package com.accelgrowth.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accelgrowth.order_service.dto.OrderRequest;
import com.accelgrowth.order_service.dto.OrderResponse;
import com.accelgrowth.order_service.service.KafkaProducerService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private KafkaProducerService producer;

	@PostMapping
	public OrderResponse placeOrder(@RequestBody OrderRequest order) {
		producer.sendOrder(order);
        return new OrderResponse("Order placed successfully", order);

	}
}
