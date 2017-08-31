package com.zxxz.lv.entity;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

@Table(name = "job")
public class Job {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "className")
    private String className;
    @Column(name = "taskName")
    private String taskName;
    @Column(name = "cron")
    private String cron;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
