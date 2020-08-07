package com.example.demo.order.dto;


import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String customerName;
    private String orderDate;
    private String shippingAddress;
    private List<OrderItems> orderItems;
    private String total;

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }
}
