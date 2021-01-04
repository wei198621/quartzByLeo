package com.tz.leo.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Author: tz_wl
 * Date: 2020/7/26 17:41
 * Content:
 */
@Component
public class CronSchedulerJob {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    private void scheduleJob1(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail= JobBuilder
                .newJob(ScheduledJob.class)
                .withIdentity("job1","group1")
                .build();
        CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule("0/6 * * * * ?");
        CronTrigger cronTrigger= TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1","group1")
                .usingJobData("name","王丽1")
                .withSchedule(scheduleBuilder)
                .build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    private void scheduleJob2(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail=JobBuilder
                .newJob(ScheduledJob2.class)
                .withIdentity("job2","group2")
                .build();
        CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule("0/12 * * * * ?");
        CronTrigger cronTrigger= TriggerBuilder
                .newTrigger()
                .withIdentity("trigger2","group2")
                .usingJobData("name","王晓丽2")
                .withSchedule(scheduleBuilder)
                .build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    ///启动 job
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler=schedulerFactoryBean.getScheduler();
        scheduleJob1(scheduler);
        scheduleJob2(scheduler);
    }








}
