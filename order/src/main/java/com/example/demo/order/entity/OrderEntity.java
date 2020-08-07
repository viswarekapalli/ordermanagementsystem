package com.example.demo.order.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue
    private int id;
    private String customerName;
    private String orderDate;
    private String shippingAddress;
    @Transient
    private List<OrderItemsEntity> orderItems;
    private String total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<OrderItemsEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemsEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
