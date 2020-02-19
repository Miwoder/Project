package com.govoronok.bstu.entity;

import lombok.Data;
import java.sql.Date;

@Data
public class CreateOrder
{
    private int id;
    private String nameOfGood;
    private Date dateOfCreateOrder;
    private Date dateOfExpectedConfirmOrder;
    private int totalNumberOfGoods;
    private int sumOfOrder;
    private String fullNameOfCustomer;
    private String orderStatus;

    private String itemName;
    private String itemInfo;
    private boolean checkbox;
    private String ProductQuality;
    private int sumOfItemPrice;

}
