package com.govoronok.bstu.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class IssueOrder
{

    private String nameOfItem;
    private Object firstPictureOfItem;
    private Object firstPictureOfReceivedItem;
    private Date currentDate;

    public void setNameOfItem(String nameOfItem) throws Exception{
        if (nameOfItem==null)
            throw new Exception("Заполните поле \"Название детали\" ");
        this.nameOfItem = nameOfItem;
    }

    public void setFirstPictureOfItem(Object firstPictureOfItem) throws Exception{
        if (firstPictureOfItem==null)
            throw new Exception("Отсутствует изображение ");
        this.firstPictureOfItem = firstPictureOfItem;
    }

    public void setFirstPictureOfReceivedItem(Object firstPictureOfReceivedItem) throws Exception {
        if (firstPictureOfReceivedItem==null)
            throw new Exception("Отсутствует изображение");
        this.firstPictureOfReceivedItem = firstPictureOfReceivedItem;
    }

    public void setCurrentDate(Date currentDate) throws Exception{
        if (currentDate==null)
            throw new Exception("Неверное значение даты");
        this.currentDate = currentDate;
    }
}
