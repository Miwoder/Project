package com.company;

import lombok.Data;

import java.util.Date;

@Data
public class CreateOrder
{
    private int id;
    private String nameOfGood;
    private String dateOfCreateOrder;

    public void setDateOfCreateOrder(Date dateOfCreateOrder) {
        this.dateOfCreateOrder = dateOfExpectedConfirmOrder;
    }
    public String getDateOfCreateOrder() {
        return dateOfCreateOrder;
    }



    public void setId(int id) {
        this.id = id;
    }


    private String dateOfExpectedConfirmOrder;
    private int totalNumberOfGoods;
    private int sumOfOrder;
    private String fullNameOfCustomer;
    private String orderStatus;

}
