package com.govoronok.bstu;

import com.govoronok.bstu.entity.Item;
import com.govoronok.bstu.entity.Manager;
import com.govoronok.bstu.entity.Order;
import util.ConnectorDB;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) throws IllegalAccessException, SQLException, InstantiationException
    {
        try {
            int id = 0;
            Scanner in = new Scanner(System.in);
          //Connection cn = ConnectorDB.getConnection();
            Manager manager = new Manager();
            ArrayList<Order> orders = new ArrayList<Order>();
            ArrayList<Item> items = new ArrayList<Item>();
            Item item = new Item();
            Order[] order = new Order[999];

            for(int x = 0;x<1; x--)
            {
                System.out.println("0-выход, 1-создать заказ, 2-удалить заказ, 3-показать заказ");
                int num = in.nextInt();

                switch (num){
                    case 0: return;
                    case 1: {
                        order[id] = new Order();
                        manager.CreateOrder(order[id], orders);
                        orders.add(order[id]);
                        id++;
                        break;
                    }
                    case 2: {
                        System.out.println("Удалить заказ с id: ");
                        int delId = in.nextInt();
                       // manager.DeleteOrder(order[delId-1], orders);
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
                    }
                }


            }

           // System.out.println(orders.get(0));

            // manager.ViewOrder(order[1]);
            //System.out.println(orders.get(0));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
