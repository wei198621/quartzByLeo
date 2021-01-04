package com.tz.leo.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * Author: tz_wl
 * Date: 2020/7/26 18:46
 * Content:  编写配置类   工厂类
 */

@Component
public class QuartzJobBeanFactory  extends AdaptableJobFactory implements ApplicationContextAware {

    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    public void setApplicationContext(final ApplicationContext context) throws BeansException {
        capableBeanFactory = context.getAutowireCapableBeanFactory();
    }
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        //进行注入
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }

}
