package com.felixzh.engine.service;

import org.quartz.SchedulerException;

public interface ITaskService {
    void createTask() throws SchedulerException;

    void startTask(String taskId) throws SchedulerException;
}
