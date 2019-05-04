package com.mailsender.mailsender.mail;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {

    private String name;
    private String mail;
    private String number;
    private String msg;
    private String res;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User(String name, String mail, String number, String msg, String res, Date date) {
        this.name = name;
        this.mail = mail;
        this.number = number;
        this.msg = msg;
        this.res = res;
        this.date = date;
    }
}
