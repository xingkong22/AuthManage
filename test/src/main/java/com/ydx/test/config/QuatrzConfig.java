package com.ydx.test.config;

import com.ydx.test.job.FirstJob;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuatrzConfig {
    @Bean
    public JobDetailFactoryBean createJob() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(FirstJob.class);
        return bean;
    }
    @Bean
    public CronTriggerFactoryBean createCron(JobDetail jobDetail) {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();

        bean.setCronExpression("0/5 * 10 * * ? 1970-2099");
        return bean;
    }
    @Bean
    public SchedulerFactoryBean createScheduler() {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        return bean;
    }
}
