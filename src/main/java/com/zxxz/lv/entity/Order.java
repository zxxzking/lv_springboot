package com.zxxz.lv.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lv on 2017/7/21.
 */
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "order_id", length = 36)
    private String id;
    @Column(name = "order_no", length = 50)
    private String no;
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date date;
    @Column(name = "quantity")
    private int quantity;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
