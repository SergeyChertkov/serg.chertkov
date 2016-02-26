package com.epam.spring.core;

import java.text.DateFormat;
import java.util.Date;

import static java.lang.Math.random;

/**
 * Created by Sergii_Chertkov on 2/26/2016.
 */
public class Event {
    private DateFormat df;
    private int id;
    private String msg;
    private Date date;

    public Event(Date date, DateFormat df){
        this.date = date; this.df = df;
    }

    @Override
    public String toString() {
        id = (int) (random()*1000);
        return String.valueOf(id) + ". " + df.format(date) + " - " + msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
