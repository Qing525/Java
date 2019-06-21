package com.ljq.schedule.util;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author : LJQ
 * @date : 2019/6/21 22:56
 */
//@Component
public class Jobs {

    //方法执行完成后5秒

    @Scheduled(fixedDelay = 5000)
    public void fixedDelayJob() {

        System.out.println("fixedDelay 每隔5秒：" + new Date());
    }

    //每隔三秒
    @Scheduled(fixedRate = 3000)

    public void fixedRateJob() {

        System.out.println("fixedRate 每隔3秒：" + new Date());

    }

    @Scheduled(cron = "0 7 23 ? * *")
    public void cornJob(){
        System.out.println(new Date()+" ...>>cron....");
    }

}
