package com.ljq.schedule.controller;

import com.ljq.schedule.util.AsyncTask;
import com.ljq.schedule.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author : LJQ
 * @date : 2019/6/21 23:14
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    AsyncTask task;

    @GetMapping("/task")

    public JsonData exeTask() {
        long start = System.currentTimeMillis();
        Future<String> task1 = task.task1();
        Future<String> task2 = task.task2();
        Future<String> task3 = task.task3();
        for (; ; ) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("执行总耗时=" + (end - start));
        return JsonData.buildSuccess(total);
    }

}
