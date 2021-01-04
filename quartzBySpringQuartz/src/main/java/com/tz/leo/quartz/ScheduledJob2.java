package com.tz.leo.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: tz_wl
 * Date: 2020/7/26 17:38
 * Content:
 */
public class ScheduledJob2 implements Job {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("CRON ----> schedule job1 is running ... + " + name + "  ---->  " + sdf.format(new Date()));
    }
}
