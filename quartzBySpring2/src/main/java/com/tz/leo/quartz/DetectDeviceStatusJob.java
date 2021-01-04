package com.tz.leo.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Author: tz_wl
 * Date: 2020/7/26 18:52
 * Content:
 */
@Component
@Slf4j
public class DetectDeviceStatusJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //解决spring bean无法自动注入 （@Autowired注入失效问题）
        //解决不了就使用工具类获取IOC中的bean对象SpringContextUtils.getBean("");
        //SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        //JobDataMap获取任务中传递的数据，实现了Map接口
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String cron = jobDataMap.getString("cron");
        //获取开启任务时设置的withIdentity
        //JobKey jobKey = context.getJobDetail().getKey();
        log.info("启动读取站号状态任务-----当前时间：{},当前线程:{},当前cron:{}",new Date(),Thread.currentThread().getName(),cron);
        try {
            //ScheduleJob任务运行时具体参数，可自定义
        }catch (Exception e) {
            log.error("读取站号状态任务运行异常：{}",e);
        }
    }

}
