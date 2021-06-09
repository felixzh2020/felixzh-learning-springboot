package com.felixzh.staticCronScheduleSingleThread.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * 默认情况下，Schedule调度任务使用单一线程串行执行。
 * 如果只有一个任务，这样做没问题。
 * 如果多个任务，一旦有任务耗时较长或者卡死，会直接导致其他任务延迟或者卡死。这种情况，就需要启用多线程。
 */

@Configuration       //标记配置类，兼备Component效果
@EnableScheduling    //开启定时任务
public class AnnotateSchedule {

    public final Logger logger = LoggerFactory.getLogger(AnnotateSchedule.class);

    /**
     * 不受上次执行时间点影响，每隔5秒再执行。需要配合多线程使用，否则单线程内遇到超过间隔时间的阻塞任务，达不到预期效果
     */
    @Scheduled(cron = "0/5 * * * * *")
    private void cronTask1() {
        logger.info("task1 " + Thread.currentThread().getName() + " " + new Date().toString());

        //模拟定时任务卡死
        try {
            Thread.sleep(10000);
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

