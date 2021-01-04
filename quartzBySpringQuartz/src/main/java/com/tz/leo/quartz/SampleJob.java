package com.tz.leo.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Author: tz_wl
 * Date: 2020/7/26 17:20
 * Content:  首先定义一个Job
 */
public class SampleJob extends QuartzJobBean {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Quartz ----> Hello, "+ this.name);
    }
}
