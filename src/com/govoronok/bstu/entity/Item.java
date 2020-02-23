package com.govoronok.bstu.entity;

import lombok.Data;

@Data
public class Item
{
    private String itemName;
    private String color;
    private Object photo;
    private String note;
    private int price;
    private int yearOfIssueFirst;
    private int yearOfIssueSecond;
    private String itemInfo;
    private String productQuality;
    private int sumOfItemPrice;
}
