package com.felixzh.engine.dynamicCronScheduleSingleThread.controller;

import com.felixzh.engine.dynamicCronScheduleSingleThread.service.DynamicCronSingleThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CronController {

    @Autowired
    DynamicCronSingleThread dynamicCronSingleThread;

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateCron(@RequestParam("cron") String cronExpression) {
        dynamicCronSingleThread.setCronExpression(cronExpression);
        return "ok";
    }
}
