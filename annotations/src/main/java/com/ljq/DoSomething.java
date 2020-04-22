package com.ljq;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author : LJQ
 * @date : 2019/6/1 9:33
 */
public class DoSomething {
    public void test() {
        System.out.println("执行自定义注解");
        System.out.println("执行自定义注解结束时间："+new Date());
    }

    public static void main(String[] args) throws InterruptedException {
        double i =1.2;
        TimeUnit.SECONDS.sleep(((long) i));
        System.out.println(1);

    }
}
