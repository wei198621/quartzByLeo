package com.tz.leo.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: tz_wl
 * Date: 2020/7/26 18:55
 * Content:
 */
@Slf4j
public class StartListener implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        //项目启动,开启读站号状态定时任务
        Environment env = event.getApplicationContext().getEnvironment();
        String cron = env.getProperty("myconfig.job.cron");
        log.info("程序启动" + Instant.now());
        Map<String,Object> param = new HashMap<>();
        param.put("cron", cron);
        QuartzManager.addJob("读站号状态1", DetectDeviceStatusJob.class, cron,param);
        QuartzManager.addJob("读站号状态2", DetectDeviceStatusJob.class, cron,param);
        QuartzManager.addJob("读站号状态3", DetectDeviceStatusJob.class, cron,param);
        QuartzManager.addJob("读站号状态4", DetectDeviceStatusJob.class, cron,param);
    }

}
