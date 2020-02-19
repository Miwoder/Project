package com.company;

import lombok.Data;

@Data
public class IssueOrder
{
    private boolean checkbox;
    private String nameOfItem;
    private Object firstPictureOfItem;
    private Object firstPictureOfReceivedItem;
    private String currentDate;
}
