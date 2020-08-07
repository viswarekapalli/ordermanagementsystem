package com.example.demo.order.service;


import com.example.demo.order.dto.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrderItems();

    int createOrderItems(Order order);

    Order getAllOrderItems(int customerId);

    Boolean validatereasonCode(int productCode);
}
