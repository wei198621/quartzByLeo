package com.tz.leo.quartz;

import org.quartz.Scheduler;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Author: tz_wl
 * Date: 2020/7/26 18:48
 * Content:
 */
@Configuration
public class QuartzConfig {
    @Bean
    public QuartzJobBeanFactory autoWiringSpringBeanJobFactory() {
        return new QuartzJobBeanFactory();
    }
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(autoWiringSpringBeanJobFactory());
        return schedulerFactoryBean;
    }
    @Bean
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }


}
