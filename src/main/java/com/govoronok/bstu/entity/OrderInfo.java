package com.govoronok.bstu.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderInfo {
    private String fullNameOfCustomer;
    private String OrderStatus;

    public String getFullNameOfCustomer() {
        return fullNameOfCustomer;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }
}
