package com.felixzh.engine.dynamicCronScheduleSingleThread.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * cron表达式支持动态修改：
 * 方式1：通过配置文件传入，需重启应用
 * 方式2：通过接口传入，无需重启应用
 */

@Service
@Slf4j
@EnableScheduling
public class DynamicCronSingleThread implements SchedulingConfigurer {

    @Value("${cron.expression}")
    private String cronExpression;

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
            log.info("定时任务处理逻辑：" + new Date());
            //模拟业务耗时
            /*try {
                Thread.sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();

            }*/
        }, (triggerContext) -> {
            CronTrigger cronTrigger = new CronTrigger(cronExpression);
            return cronTrigger.nextExecutionTime(triggerContext);
        });
    }
}
