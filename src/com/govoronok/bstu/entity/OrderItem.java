package com.govoronok.bstu.entity;

import lombok.Data;

@Data
public class OrderItem
{
    private String itemName;
    private String itemInfo;

    private String productQuality;
    private int sumOfItemPrice;
}
