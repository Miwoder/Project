package com.govoronok.bstu;

import com.govoronok.bstu.entity.Item;
import com.govoronok.bstu.entity.Manager;
import com.govoronok.bstu.entity.Order;
import util.ConnectorDB;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Controller {

    public static void main(String[] args) throws IllegalAccessException, SQLException, InstantiationException
    {
        try {
            Connection cn = ConnectorDB.getConnection();

            Scanner in = new Scanner(System.in);
            Manager manager = new Manager();
            ArrayList<Order> orders = new ArrayList<Order>();
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












        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
