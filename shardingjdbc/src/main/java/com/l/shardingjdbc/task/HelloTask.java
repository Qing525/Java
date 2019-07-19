package com.l.shardingjdbc.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 任务类
 */
public class HelloTask extends QuartzJobBean {
    private static final Logger log = LoggerFactory.getLogger(HelloTask.class);
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("------------"+new Date());

    }
}
