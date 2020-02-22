package com.govoronok.bstu.entity;

import lombok.Data;

@Data
public class EmailForm
{
    private String sendToEmail;
    private String Topic;
    private String letterTemplate;
    private String text;

    public void setSendToEmail(String sendToEmail) throws Exception
    {
        if (sendToEmail==null)
            throw new Exception("Заполните поле \"Получатель\" ");
        this.sendToEmail = sendToEmail;
    }

    public void setLetterTemplate(String letterTemplate) throws  Exception{
        if (letterTemplate==null)
            throw new Exception("Заполните поле \"Форма\" ");
        this.letterTemplate = letterTemplate;
    }

    public void setText(String text) throws Exception {
        if (text==null)
            throw new Exception("Заполните поле \"Текст\" ");
        this.text = text;
    }
}
