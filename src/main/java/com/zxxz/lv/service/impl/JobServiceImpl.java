package com.zxxz.lv.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.zxxz.lv.entity.Job;
import com.zxxz.lv.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private DbHelper dbHelper;


    @Override
    public Job getJob(String className,String taskName){
        String sql = "select * from job where class_name=? and task_name=?";
        Job job = dbHelper.queryForObject(sql, Job.class, className, taskName);
        return job;
    }
}
