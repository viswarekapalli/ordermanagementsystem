package com.example.demo.orderitems.controller;

import com.example.demo.orderitems.dto.OrderItems;
import com.example.demo.orderitems.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderItemsController {

    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/getAllOrderItems")
    public List<OrderItems> getOrderItems(){
        return orderItemService.getAllOrderItems();
    }

    @PostMapping("/createOrderItems")
    public String createOrderItems(@RequestBody OrderItems orderItems){
        return orderItemService.createOrderItems(orderItems);
    }
    @GetMapping("/getAllOrderItems/{reasonCode}")
    public OrderItems getOrderItemsByReasonCode(@PathVariable Integer reasonCode){
        return orderItemService.getOrderItemsByReasonCode(reasonCode);
    }

}
