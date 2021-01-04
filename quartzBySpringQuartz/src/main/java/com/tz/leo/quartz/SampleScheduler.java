package com.tz.leo.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: tz_wl
 * Date: 2020/7/26 17:26
 * Content:
 */
@Configuration
public class SampleScheduler {

    @Bean
    public JobDetail sampleJobDetail(){
        // 链式编程,可以携带多个参数,在Job类中声明属性 + setter方法
        // JobBuilder 无构造函数，
        // 只能通过 JobBuilder 的静态方法 newJob(Class jobClass)生成 JobBuilder 实例。
        // withIdentity  示例名称
        // UsingJobData  注入参数
        return JobBuilder
                .newJob(SampleJob.class)
                .withIdentity("sampleJob")
                .usingJobData("name","world")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger sampleJobTrigger() {
        // 每隔两秒执行一次
        SimpleScheduleBuilder scheduleBuilder =
                SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever();
        return TriggerBuilder.newTrigger()
                .forJob(sampleJobDetail())
                .withIdentity("sampleTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
