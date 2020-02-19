package com.govoronok.bstu.entity;

import lombok.Data;

@Data
public class EditOrder
{
    private String itemName;
    private int price;
    private int yearOfIssueFirst;
    private int yearOfIssueSecond;
    private String newOrNot;
    private String color;
    private Object photo;
    private String note;

}
