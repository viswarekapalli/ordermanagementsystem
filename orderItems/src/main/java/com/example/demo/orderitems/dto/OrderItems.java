package com.example.demo.orderitems.dto;

import lombok.Data;

@Data
public class OrderItems {
    private int productCode;
    private String quantity;
    private String productName;

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }
}
