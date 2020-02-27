package com.govoronok.bstu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchGood
{
    private String nameOfGood;
    private String firstDate;
    private String secondDate;
    private String nameOfItem;
    private String customerSurname;
}
