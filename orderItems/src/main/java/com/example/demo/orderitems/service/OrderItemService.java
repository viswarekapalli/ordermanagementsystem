package com.example.demo.orderitems.service;


import com.example.demo.orderitems.dto.OrderItems;

import java.util.List;

public interface OrderItemService {
    List<OrderItems> getAllOrderItems();

    String createOrderItems(OrderItems orderItems);

    OrderItems getOrderItemsByReasonCode(Integer reasonCode);
}
