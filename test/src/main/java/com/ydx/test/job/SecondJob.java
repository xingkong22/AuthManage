package com.ydx.test.job;

import com.aliyuncs.exceptions.ClientException;
import com.ydx.test.common.SMSUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.jms.annotation.JmsListener;

//从AMQ中读取消息，根据顺序发送短信
public class SecondJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            SMSUtils.sendSms("");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
