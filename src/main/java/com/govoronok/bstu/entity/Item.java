package com.govoronok.bstu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item
{
    private String itemName;
    private String color;
    private Object photo;   ////////
    private String note;
    private int price;
    private int yearOfIssueFirst;
    private int yearOfIssueSecond;
    private String itemInfo;
    private String productQuality;
}
