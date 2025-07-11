package com.accelgrowth.order_service.dto;


public class OrderRequest {
	
	private String item;
	private int quantity;
	
	// Getters and Setters
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "item='" + item + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
