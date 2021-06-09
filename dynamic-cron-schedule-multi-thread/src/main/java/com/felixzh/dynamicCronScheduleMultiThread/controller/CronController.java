package com.felixzh.dynamicCronScheduleMultiThread.controller;

import com.felixzh.dynamicCronScheduleMultiThread.service.DynamicCronMultiThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CronController {

    @Autowired
    DynamicCronMultiThread dynamicCronMultiThread;

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateCron(@RequestParam("cron") String cronExpression) {
        dynamicCronMultiThread.setCronExpression(cronExpression);
        return "ok";
    }
}
