package com.ljq;

import java.util.concurrent.TimeUnit;

/**
 * @author : lijq
 * @date : 2020/4/13 12:41
 */
public class VolatileDemo {
  volatile   static boolean flag = true;

    static void print() {
        while (flag) {

        }
        System.out.println("END...");
    }

    public static void main(String[] args) {
        ;
        new Thread(() -> VolatileDemo.print()).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        ;
        new Thread(() -> VolatileDemo.print()).start();

    }
}