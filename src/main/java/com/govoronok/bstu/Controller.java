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



                /*

            Date date = new Date();
            Scanner in = new Scanner(System.in);
            Manager manager = new Manager();

            ArrayList<Item> items = new ArrayList<Item>();
            Item item = new Item();
            File fileOrders = new File("Orders.txt");
            BufferedReader br = null;
            Order[] order = new Order[999];

            for(int x = 0;x<1; x--)
            {
                System.out.println("0-выход, 1-создать заказ, 2-удалить заказ, 3-показать заказ");
                int num = in.nextInt();

                switch (num){
                    case 0: return;
                    case 1: {
                        System.out.println("Введите имя заказчика");
                        String fullNameOfCustomer = in.nextLine();
                        System.out.println("Введите email заказчика");
                        String email = in.nextLine();
                       // statement.executeUpdate("INSERT INTO _order (id,fullNameOfCustomer,customerEmail, dateOfCreateOrder," +
                       //         " dateOfExpectedConfirmOrdder, totalNumberOfItems, sumOfOrder,orderStatus )" +
                        //        "values(id,fullNameOfCustomer,email,date,'2020.02.02',4,400,Ready)");

                        int id=0;
                        while (order[id]!=null){
                            id++;
                        }
                        order[id] = new Order();
                        manager.CreateOrder(order[id], orders, id);
                        orders.add(order[id]);
                        try {
                            if(!fileOrders.exists()) fileOrders.createNewFile();
                            PrintWriter pw = new PrintWriter(fileOrders);
                            pw.println(order[id]);
                            pw.close();
                        }
                        catch (IOException e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Удалить заказ с id: ");
                        int delId = in.nextInt();
                        orders.remove(delId-1);
                        order[delId-1] = null;
                        break;
                    }
                    case 3:{
                        System.out.println("Показать заказ с id: ");
                        int showId = in.nextInt();
                        manager.ViewOrder(order[showId-1], orders);
                        //для тестов
                        System.out.println(orders.get(showId));
                        try {
                            br = new BufferedReader(new FileReader("Orders.txt"));
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        }
                        catch (IOException e) {
                            System.out.println(e);
                        }
                        finally{
                            br.close();
                        }
                    }
                }
            }

        cn.close();
        }
        */

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
