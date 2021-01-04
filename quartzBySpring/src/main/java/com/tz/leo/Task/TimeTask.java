package com.tz.leo.Task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: tz_wl
 * Date: 2020/7/26 16:12
 * Content:
 */
@Configuration
public class TimeTask {

    private static final SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");

    //  https://blog.csdn.net/wei198621/article/details/112182563
    //  表示 每隔6秒执行一次
    //   修饰范围： 用在方法上   作用：标识这个方法是一个定时任务方法
    //  cron  cron表达式  作用： 决定当前任务方法循环周期
    //   秒  分 时 日 月 周  星期
    // cron 表达式 在线生成器   https://cron.qqe2.com/
    //  spring 封装的  cron表达式 只支持6位的， 第七位的年 不要写 （算是spring的小BUG）
    // 启动两个任务 在线程池内的同一个线程
    @Scheduled(cron = "*/6 * * * * ?")
    public void runCronTest(){
        String threadName= Thread.currentThread().getName();
        System.out.println("Thread name is "+ threadName+"  cron test time  is  ... "+ sdf.format(new Date()));
    }

    // 定时频率刷新 任务
    @Scheduled(fixedRate = 5000)
    public void runFixRateTest(){
        String threadName= Thread.currentThread().getName();
        System.out.println("Thread name is "+ threadName+"  fixRate test time is ..."+ sdf.format(new Date()));
    }

}
