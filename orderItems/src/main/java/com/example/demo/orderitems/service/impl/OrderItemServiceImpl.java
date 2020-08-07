package com.example.demo.orderitems.service.impl;

import com.example.demo.orderitems.dto.OrderItems;
import com.example.demo.orderitems.entity.OrderItemsEntity;
import com.example.demo.orderitems.repository.OrderItemsRepository;
import com.example.demo.orderitems.service.OrderItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemsRepository orderItemsRepository;
    @Override
    public List<OrderItems> getAllOrderItems() {
        List<OrderItemsEntity> orderItemsEntities =  orderItemsRepository.findAll();
        Type listType = new TypeToken<List<OrderItems>>() {}.getType();
        return new ModelMapper().map(orderItemsEntities, listType);
    }

    @Override
    public String createOrderItems(OrderItems orderItems) {
        ModelMapper modelMapper = new ModelMapper();
        OrderItemsEntity orderItemsEntity = modelMapper.map(orderItems,OrderItemsEntity.class);
        orderItemsRepository.save(orderItemsEntity);
        return String.valueOf(HttpStatus.OK);
    }

    @Override
    public OrderItems getOrderItemsByReasonCode(Integer reasonCode) {
        Optional<OrderItemsEntity> orderItemsEntities =  orderItemsRepository.findByProductCode(reasonCode);
        return new ModelMapper().map(orderItemsEntities.get(), OrderItems.class);
    }
}
