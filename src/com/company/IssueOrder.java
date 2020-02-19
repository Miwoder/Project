package com.company;

import lombok.Data;

import java.sql.Date;

@Data
public class IssueOrder
{
    private boolean checkbox;
    private String nameOfItem;
    private Object firstPictureOfItem;
    private Object firstPictureOfReceivedItem;
    private Date currentDate;
}
