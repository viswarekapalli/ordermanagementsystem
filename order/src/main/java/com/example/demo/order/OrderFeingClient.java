package com.example.demo.order;

import com.example.demo.order.dto.OrderItems;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:7000",name = "orderItem")
public interface OrderFeingClient {
    @GetMapping("/getAllOrderItems/{reasonCode}")
    OrderItems getAllOrderItemsByReasonCode(@PathVariable int reasonCode);
}
