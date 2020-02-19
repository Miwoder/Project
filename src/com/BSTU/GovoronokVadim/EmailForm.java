package com.BSTU.GovoronokVadim;

import lombok.Data;

@Data
public class EmailForm
{
    private String sendToEmail;
    private String Topic;
    private String letterTemplate;
    private String text;
}
