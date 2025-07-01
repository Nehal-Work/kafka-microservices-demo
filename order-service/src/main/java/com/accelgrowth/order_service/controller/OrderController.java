package com.accelgrowth.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accelgrowth.order_service.service.KafkaProducerService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private KafkaProducerService producer;

	@PostMapping
	public String placeOrder(@RequestBody String order) {
		producer.sendOrder(order);
		return "Order placed: " + order;
	}
}
