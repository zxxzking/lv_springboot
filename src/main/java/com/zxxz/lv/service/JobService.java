package com.zxxz.lv.service;

import com.zxxz.lv.entity.Job;

public interface JobService {
    Job getJob(String className, String taskName);
}
