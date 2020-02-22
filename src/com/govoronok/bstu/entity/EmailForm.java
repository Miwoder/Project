package com.govoronok.bstu.entity;

import lombok.Data;

@Data
public class EmailForm
{
    private String sendToEmail;
    private String Topic;

    public EmailForm(String topic, String letterTemplate, String text) {

        Topic = topic;
        this.letterTemplate = letterTemplate;
        if (text==null || text=="")
        {
            //throw new Exception("Заполните поле");
            this.text = text;
        }
    }

    private String letterTemplate;
    private String text;
}
