package com.govoronok.bstu;

import com.govoronok.bstu.entity.Item;
import com.govoronok.bstu.entity.Manager;
import com.govoronok.bstu.entity.Order;
import com.govoronok.bstu.entity.Quality;
import org.apache.log4j.Logger;
import util.ConnectorDB;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class Controller {

    public static  ArrayList<Order> orders = new ArrayList<Order>();
    private static final Logger log = Logger.getLogger(Controller.class);
    public static void main(String[] args) throws IllegalAccessException, SQLException, InstantiationException
    {
        try {
            Connection cn = ConnectorDB.getConnection();
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * From _order");

            while (resultSet.next()){
                Item item = new Item(resultSet.getString(1));
                String name = resultSet.getString(2);
                Order order = new Order(item);
                orders.add(order);
            }

            for (Order order : orders)
                System.out.println(String.format("ID: " + order.getId() + ", " +
                        "Имя заказчика: " + order.getFullNameOfCustomer() + ", " +
                        "Дата создания заказа: " + order.getDateOfCreateOrder() + ", " +
                        "Дата предполагаемого выполнения заказа: " + order.getDateOfExpectedConfirmOrder() + ", " +
                        "Суммарное число деталей в заказе: " + order.getTotalNumberOfItems() + ", " +
                        "Сумма заказа: " + order.getSumOfOrder() + ", " +
                        "Статус заказа: " + order.getOrderStatus()));

            Order myOrder = new Order(new Item("Болт"));
            if (!orders.contains(myOrder)) {
                String str = String.format("Not found: ",
                        myOrder.getId(), myOrder.getFullNameOfCustomer());
                log.error(str);
            }
            else {
                log.info(String.format("Order with id: " + myOrder.getId() + ", " +
                        "Имя заказчика: " + myOrder.getFullNameOfCustomer() + ", " +
                        "Дата создания заказа: " + myOrder.getDateOfCreateOrder() + ", " +
                        "Дата предполагаемого выполнения заказа: " + myOrder.getDateOfExpectedConfirmOrder() + ", " +
                        "Суммарное число деталей в заказе: " + myOrder.getTotalNumberOfItems() + ", " +
                        "Сумма заказа: " + myOrder.getSumOfOrder() + ", " +
                        "Статус заказа: " + myOrder.getOrderStatus()));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
