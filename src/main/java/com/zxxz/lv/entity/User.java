package com.zxxz.lv.entity;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Table;

import java.sql.Timestamp;


@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "passWord")
    private String passWord;
    @Column(name = "email")
    private String email;
    @Column(name = "inserttime")
    private Timestamp inserttime;
    @Column(name = "updatetime")
    private Timestamp updatetime;
    @Column(name = "isactive")
    private Short isactive = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getInserttime() {
        return inserttime;
    }

    public void setInserttime(Timestamp inserttime) {
        this.inserttime = inserttime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Short getIsactive() {
        return isactive;
    }

    public void setIsactive(Short isactive) {
        this.isactive = isactive;
    }
}
