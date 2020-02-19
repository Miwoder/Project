package com.company;

import lombok.Data;

import java.sql.Date;

@Data
public class CreatePhotoList
{
    private String nameOfFile;
    private Date dateOfUpload;
    private String note;
}
