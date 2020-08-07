package com.example.demo.order.controller;

import com.example.demo.order.dto.Order;
import com.example.demo.order.dto.OrderItems;
import com.example.demo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/getAllOrders")
    public List<Order> getOrderItems(){
        return orderService.getAllOrderItems();
    }

    @PostMapping("/createOrder")
    public int createOrderItems(@RequestBody Order order){
         List<OrderItems> orderItems = order.getOrderItems().stream().
                filter(orderItem -> orderService.validatereasonCode(orderItem.getProductCode())).collect(Collectors.toList());
        order.setOrderItems(orderItems);
        return orderService.createOrderItems(order);
    }

    @GetMapping("/getAllOrders/{id}")
    public Order getOrderItems(@PathVariable int id){

        return orderService.getAllOrderItems(id);
    }
}
