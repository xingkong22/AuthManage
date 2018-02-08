package com.ydx.test.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

//访问数据库，获取会员的手机号码或者信箱，然后存到amq中
public class FirstJob implements Job{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            //读数据库存入mq
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
