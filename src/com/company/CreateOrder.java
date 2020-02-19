package com.company;

import lombok.Data;

import java.util.Date;

@Data
public class CreateOrder
{
    private int id;
    private String nameOfGood;
    private String dateOfCreateOrder;
    private String dateOfExpectedConfirmOrder;
    private int totalNumberOfGoods;
    private int sumOfOrder;
    private String fullNameOfCustomer;
    private String orderStatus;

    private String itemName;
    private String itemInfo;
    private boolean checkbox;
    private String ProductQuality;
    private int sumOfItem;

}
