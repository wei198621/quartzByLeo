package com.tz.leo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling       //开启  修饰范围：用在类上  作用，用来标识这个类是一个定时任务类
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( Thread.currentThread().getName() + "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
