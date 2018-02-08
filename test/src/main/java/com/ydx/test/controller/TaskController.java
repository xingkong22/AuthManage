package com.ydx.test.controller;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private JobDetail jobDetail;
    @Autowired
    private CronTrigger cronTrigger;
    @Autowired
    private Scheduler scheduler;

    @RequestMapping("start")
    public String start() {
        try {
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "start";
    }

    @RequestMapping("pause")
    public String pause() {
        try {
            scheduler.pauseJob(jobDetail.getKey());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "pause";
    }

    @RequestMapping("resume")
    public String resume() {
        try {
            scheduler.resumeJob(jobDetail.getKey());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "resume";
    }
}
