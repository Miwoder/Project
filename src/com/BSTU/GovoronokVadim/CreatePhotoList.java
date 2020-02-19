package com.BSTU.GovoronokVadim;

import lombok.Data;

import java.sql.Date;

@Data
public class CreatePhotoList
{
    private String nameOfFile;
    private Date dateOfUpload;
    private String note;
}
