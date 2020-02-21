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
}
