package com.govoronok.bstu.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderInfo {
    private String fullNameOfCustomer;
    private String OrderStatus;

}
