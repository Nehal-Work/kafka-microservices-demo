package com.accelgrowth.inventory_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accelgrowth.inventory_service.service.KafkaConsumerService;
@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	 	@Autowired
	    private KafkaConsumerService kafkaConsumerService;

	    @GetMapping("/stock/{item}")
	    public int getItemStock(@PathVariable String item) {
	        return kafkaConsumerService.getStock(item);
	    }
}
