package com.example.demo.order.service.impl;

import com.example.demo.order.OrderFeingClient;
import com.example.demo.order.dto.Order;
import com.example.demo.order.entity.OrderEntity;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.order.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderFeingClient orderFeingClient;
    @Override
    public List<Order> getAllOrderItems() {
        List<OrderEntity> orderItemsEntities =  orderRepository.findAll();
        Type listType = new TypeToken<List<Order>>() {}.getType();
        return new ModelMapper().map(orderItemsEntities, listType);
    }

    @Override
    public int createOrderItems(Order order) {
        ModelMapper modelMapper = new ModelMapper();
        OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
        orderEntity = orderRepository.save(orderEntity);
        return orderEntity.getId();
    }

    @Override
    public Order getAllOrderItems(int customerId) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<OrderEntity> orderEntity = orderRepository.findById(customerId);
        Order map = modelMapper.map(orderEntity.get(), Order.class);
        return map;
    }

    @Override
    public Boolean validatereasonCode(int productCode) {
        return orderFeingClient.getAllOrderItemsByReasonCode(productCode) !=null;
    }
}
