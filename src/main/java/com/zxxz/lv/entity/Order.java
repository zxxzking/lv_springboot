package com.zxxz.lv.entity;

import java.util.Date;

/**
 * Created by Lv on 2017/7/21.
 */
public class Order {

    private String no;

    private Date date;

    private int quantity;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
