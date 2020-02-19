package com.govoronok.bstu;

import com.govoronok.bstu.entity.CreateOrder;
import util.ConnectorDB;

import java.sql.Connection;
import java.sql.SQLException;

public class Controller {

    public static void main(String[] args) throws IllegalAccessException, SQLException, InstantiationException
    {

        Connection cn = ConnectorDB.getConnection();
    }
}
