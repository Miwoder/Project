package com.govoronok.bstu;

import com.govoronok.bstu.entity.*;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import Serial.DeserializerC;
import Serial.SerializerC;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.ConnectorDB;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class Controller {

    public static List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
    private static final Logger log = Logger.getLogger(Controller.class);



    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("resources/db.properties"));

        try {
            Connection cn = ConnectorDB.getConnection();
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * From _order");

            while (resultSet.next()){
                String customerName = resultSet.getString(1);
                String status = resultSet.getString(2);
                OrderInfo orderInfo = new OrderInfo(customerName,status);
                orderInfos.add(orderInfo);
            }

            for (OrderInfo orderInfo : orderInfos)
                System.out.println(String.format("Customer name: %s, order status: %s",
                        OrderInfo.getFullNameOfCustomer(), OrderInfo.getOrderStatus()));

            ObjectMapper objectMapper = new ObjectMapper();
            SimpleModule simpleModule = new SimpleModule("SerialDeserial", new Version(1, 0, 0, null, null, null));
            simpleModule.addDeserializer(List.class,new DeserializerC());
            simpleModule.addSerializer(OrderInfo.class, new SerializerC());
            objectMapper.registerModule(simpleModule);


            objectMapper.writeValue(new File("src/main/resources/data.json"), orderInfos);;


            List<OrderInfo> newOrderInfos = objectMapper.readValue(new File("src/main/resources/data.json"), List.class);


            OrderInfo neOrder = new OrderInfo("Ivan","Ready");
            newOrderInfos.add(neOrder);


            log.info("Apache POI");
            FileOutputStream outputStream = new FileOutputStream(new File("src/main/resources/order.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook();
            log.info("Create work book");
            XSSFSheet sheet = workbook.createSheet("Order");
            log.info("Create sheet");
            log.info("Start filling sheet");
            int rowindex = 0;
            XSSFRow row = sheet.createRow(rowindex);
            row.createCell(0).setCellValue("Customer Name");
            row.createCell(1).setCellValue("Order Status");
            for (OrderInfo orderInfo: newOrderInfos){
                row = sheet.createRow(++rowindex);
                row.createCell(0).setCellValue(orderInfo.getFullNameOfCustomer());
                row.createCell(1).setCellValue(orderInfo.getOrderStatus());
            }

            workbook.write(outputStream);
            outputStream.close();

            OrderInfo orderInfo = new OrderInfo("Oleg","Not ready");
            if (!OrderInfos.contains(orderInfo)) {
                String str = String.format("Not found order with customer name: %s and status %s",
                        orderInfo.getFullNameOfCustomer(), orderInfo.getOrderStatus());
                log.error(str);
            }
            else {
                log.info(String.format("Order with customer name: %s and status %s",
                        orderInfo.getFullNameOfCustomer(), orderInfo.getOrderStatus()));
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
