package com.felixzh.dynamicCronScheduleMultiThread.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * cron表达式支持动态修改：
 * 方式1：通过配置文件传入，需重启应用
 * 方式2：通过接口传入，无需重启应用
 */

@Service
@Slf4j
@EnableScheduling
@Configuration
public class DynamicCronMultiThread implements SchedulingConfigurer {

    @Value("${cron.expression}")
    private String cronExpression;

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //启用多线程
        taskRegistrar.setScheduler(taskScheduler());

        taskRegistrar.addTriggerTask(() -> {
            log.info(Thread.currentThread().getName() + " 定时任务 1 处理逻辑：" + new Date());
            //模拟业务耗时
            try {
                Thread.sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }, (triggerContext) -> {
            CronTrigger cronTrigger = new CronTrigger(cronExpression);
            return cronTrigger.nextExecutionTime(triggerContext);
        });

        taskRegistrar.addTriggerTask(() -> {
            log.info(Thread.currentThread().getName() + " 定时任务 2 处理逻辑：" + new Date());
        }, (triggerContext) -> {
            CronTrigger cronTrigger = new CronTrigger(cronExpression);
            return cronTrigger.nextExecutionTime(triggerContext);
        });

    }

    //启用多线程
    @Bean(destroyMethod = "shutdown")
    public ScheduledExecutorService taskScheduler() {
        return Executors.newScheduledThreadPool(5);
    }

/*    @Bean(value = "taskScheduler")
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("felixzh-");
        taskScheduler.initialize();
        return taskScheduler;
    }*/
}
