package com.tiza.leo.qurartz01;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: tz_wl
 * Date: 2021/1/4 16:33
 * Content:
 */
public class TestTimer {

    private static int period = 2000;  //间隔时间 2秒

    public static void main(String[] args) {
        TimerTask timerTask1 = new TimerTask() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "    ====== 定时任务1： ========");
                try {
                    Thread.sleep(period);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        TimerTask timerTask2 = new TimerTask() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "    ====== 定时任务2： ========");
            }
        };


        //timer 是原子的  线程安全的    多任务执行时候 线程等待
        Timer timer = new Timer();   // 一个timer对象在执行多个任务的时候使用同一线程
        //执行定时任务
        //参数1： timerTask对象  定时任务对象
        //参数2： 任务什么时候启动
        //参数3： 执行任务时间间隔
        timer.schedule(timerTask1, new Date(), period);
        timer.schedule(timerTask2, new Date(), period);
    }
}
