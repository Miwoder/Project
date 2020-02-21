package com.govoronok.bstu.entity;

import lombok.Data;
import java.sql.Date;

@Data
public class Order
{
    private int id;
    private String nameOfGood;
    private Date dateOfCreateOrder;
    private Date dateOfExpectedConfirmOrder;
    private int totalNumberOfGoods;
    private int sumOfOrder;
    private String fullNameOfCustomer;
    private String orderStatus;
    private int price;


}
