package com.govoronok.bstu.entity;

import com.govoronok.bstu.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Manager
{
    int id=1;
    Date date = new Date();
    Scanner in = new Scanner(System.in);
    int sumOfOrder = 0;

    public Item CreateItem(Item item) throws Exception
    {
        item.setItemName("Bolt ");
        item.setColor("blue");
        item.setItemInfo("for buildings");
        item.setPrice(2);
        item.setProductQuality("new");
        return item;
    }
    public Order CreateOrder(Order order, ArrayList<Order> orders) throws Exception {
        ReadinessStatus notReady = ReadinessStatus.NotReady;

        order.setId(id);
        id++;
        order.setDateOfCreateOrder(date);
        //order.setDateOfExpectedConfirmOrder();
        System.out.println("Введите имя заказчика");
        String fullNameOfCustomer = in.nextLine();
        order.setFullNameOfCustomer(fullNameOfCustomer);
      //  for(int x = 0; x<= ; x++) {
        //    sumOfOrder++;
        //}
        order.setSumOfOrder(sumOfOrder);
        order.setOrderStatus(notReady.toString());
        orders.add(order);
        return order;
    }

    public Order ViewOrder(Order order, ArrayList<Order> orders) throws Exception{
        System.out.println("ID: " + order.getId() + ", " +
                "Имя заказчика: " + order.getFullNameOfCustomer() + ", " +
                "Дата создания заказа: " + order.getDateOfCreateOrder() + ", " +
                "Дата предполагаемого выполнения заказа: " + order.getDateOfExpectedConfirmOrder() + ", " +
                "Суммарное число деталей в заказе: " + order.getTotalNumberOfItems() + ", " +
                "Сумма заказа: " + order.getSumOfOrder() + ", " +
                "Статус заказа: " + order.getOrderStatus());

        return order;
    }

    //public void DeleteOrder(Order order, ArrayList<Order> orders) throws Exception{
      //  orders.remove(order);

    //}


}
