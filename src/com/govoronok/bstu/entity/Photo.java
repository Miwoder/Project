package com.govoronok.bstu.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Photo
{
    private String nameOfFile;
    private Date dateOfUpload;
    private String note;
}
