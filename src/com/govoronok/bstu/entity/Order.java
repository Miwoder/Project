package com.govoronok.bstu.entity;

import lombok.Data;
import java.sql.Date;

@Data
public class Order
{
    private int id;
    private Date dateOfCreateOrder;
    private Date dateOfExpectedConfirmOrder;

    public void setId(int id) throws Exception{
        Integer itr = null;
        if (id==itr)
            throw new Exception("Заполните поле \"ID\" ");
        this.id = id;
    }

    public void setDateOfCreateOrder(Date dateOfCreateOrder) throws Exception {
        if (dateOfCreateOrder==null)
            throw new Exception("Заполните поле \"Дата создания\" ");
        this.dateOfCreateOrder = dateOfCreateOrder;
    }

    public void setDateOfExpectedConfirmOrder(Date dateOfExpectedConfirmOrder) throws Exception {
        if (dateOfExpectedConfirmOrder==null)
            throw new Exception("Заполните поле \"Дата ожидаемого выполнения\" ");
        this.dateOfExpectedConfirmOrder = dateOfExpectedConfirmOrder;
    }

    public void setTotalNumberOfItems(int totalNumberOfItems) throws Exception{
        if (totalNumberOfItems==0)
            throw new Exception("Количество деталей в заказе не может равняться 0");
        this.totalNumberOfItems = totalNumberOfItems;
    }

    private int totalNumberOfItems;
    private String fullNameOfCustomer;
    private int sumOfOrder;
    private String orderStatus;



}
