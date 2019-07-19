package com.l.shardingjdbc.config;

import com.l.shardingjdbc.task.HelloTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TaskConfig {


    @Bean
    public JobDetail jobDetail() {

        return JobBuilder.newJob(HelloTask.class).withIdentity("hello").storeDurably().build();
    }

    @Bean
    public CronTrigger simpleTrigger() {

        // SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(String.format("0 */1 * * * ?")).withMisfireHandlingInstructionDoNothing();

        CronTrigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail()).withIdentity("trigger").withDescription("simple类型的触发器").withSchedule(cronScheduleBuilder).build();

        return trigger;
    }


}
