package com.accelgrowth.order_service.dto;

public class OrderResponse {
	
	private String message;
    private OrderRequest order;

    public OrderResponse(String message, OrderRequest order) {
        this.message = message;
        this.order = order;
    }

    public String getMessage() {
        return message;
    }

    public OrderRequest getOrder() {
        return order;
    }

}
