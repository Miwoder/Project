package com.govoronok.bstu.entity;

import lombok.Data;

@Data
public class Item
{

    private String color;
    private Object photo;
    private String note;
    private int price;
    private int yearOfIssueFirst;
    private int yearOfIssueSecond;
    private String itemName;
}
