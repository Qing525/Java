package com.ljq.schedule.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author : LJQ
 * @date : 2019/6/21 23:07
 */
@Component
@Async
public class AsyncTask {

public Future<String> task1(){
    long start=System.currentTimeMillis();

    try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

    long end=System.currentTimeMillis();

    System.out.println("任务一耗时："+(end-start));

    return new AsyncResult<String>("任务1");
}
    public Future<String> task2(){
        long start=System.currentTimeMillis();

        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

        long end=System.currentTimeMillis();

        System.out.println("任务二耗时："+(end-start));

        return new AsyncResult<String>("任务2");
    }
    public Future<String> task3(){
        long start=System.currentTimeMillis();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        long end=System.currentTimeMillis();

        System.out.println("任务三耗时："+(end-start));

        return new AsyncResult<String>("任务3");
    }
}
