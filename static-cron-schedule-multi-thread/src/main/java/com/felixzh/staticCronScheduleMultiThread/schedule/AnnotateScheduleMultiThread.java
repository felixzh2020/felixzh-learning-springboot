package com.felixzh.staticCronScheduleMultiThread.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration       //标记配置类，兼备Component效果
@EnableScheduling    //开启定时任务
public class AnnotateScheduleMultiThread {

    public final Logger logger = LoggerFactory.getLogger(AnnotateScheduleMultiThread.class);

    @Async   //使用线程池
    @Scheduled(cron = "* * * * * *")
    public void task() {
        logger.info(Thread.currentThread().getName() + " " + new Date().toString());
        //模拟定时任务卡死
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //    @Scheduled(cron = "0/5 * * * * *")
//    private void cronTask2() {
//        logger.info("task2 " + Thread.currentThread().getName() + " " + new Date().toString());
//    }
//
//    /**
//     * 上次执行 完成时间点 之后5秒再执行
//     */
//    @Scheduled(fixedDelay = 5000)
//    private void fixedDelay() {
//        logger.info("fixedDelay " + Thread.currentThread().getName() + " " + new Date().toString());
//    }
//
//    /**
//     * 上次执行 开始时间点 之后5秒再执行
//     */
//    @Scheduled(fixedRate = 5000)
//    private void fixedRate() {
//        logger.info("fixedRate " + Thread.currentThread().getName() + " " + new Date().toString());
//    }
}
