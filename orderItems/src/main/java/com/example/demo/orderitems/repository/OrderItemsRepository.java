package com.example.demo.orderitems.repository;

import com.example.demo.orderitems.dto.OrderItems;
import com.example.demo.orderitems.entity.OrderItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity,Integer> {
 Optional<OrderItemsEntity> findByProductCode(Integer productCode);
}
