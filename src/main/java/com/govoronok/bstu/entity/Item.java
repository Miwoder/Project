package com.govoronok.bstu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Item
{
    private String itemName;
    private String color;
    private String photo;
    private String note;
    private int price;
    private int yearOfIssueFirst;
    private int yearOfIssueSecond;
    private String itemInfo;
    private String productQuality;

    private Item(String itemName, String color, String photo, String note, int price, int yearOfIssueFirst,
                int yearOfIssueSecond, String itemInfo, String productQuality) {
        this.itemName = itemName;
        this.color = color;
        this.photo = photo;
        this.note = note;
        this.price = price;
        this.yearOfIssueFirst = yearOfIssueFirst;
        this.yearOfIssueSecond = yearOfIssueSecond;
        this.itemInfo = itemInfo;
        this.productQuality = productQuality;
    }

    public Item(String itemName){
        this.itemName=itemName;
    }

}
