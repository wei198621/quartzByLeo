package com.tz.leo.quartz;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Author: tz_wl
 * Date: 2020/7/26 18:02
 * Content:
 */

@Configuration
@EnableScheduling
@Component
public class SchedulerListener {
    @Autowired
    public CronSchedulerJob schedulerJobs;

    @Scheduled(cron = "0 47 16 24 1 ?")
    public void schedule() throws SchedulerException {
        schedulerJobs.scheduleJobs();
        System.out.println();
    }
}
