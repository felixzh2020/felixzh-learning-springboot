package com.felixzh.engine.staticCronScheduleMultiThread.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 方式1：定义线程池，该方式优先级低于AsyncConfigurer2
 */

@Configuration
@EnableAsync        //开启线程池
public class AsyncConfigurer1 {

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("AsyncConfig1-");
        executor.initialize();
        return executor;
    }

}
