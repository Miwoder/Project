package com.govoronok.bstu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo
{
    private String nameOfFile;
    private Date dateOfUpload;
    private String note;
}
