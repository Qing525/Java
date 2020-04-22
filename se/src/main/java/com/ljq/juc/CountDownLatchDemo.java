package com.ljq.juc;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 一个线程等待其他线程执行完在执行
 */
public class CountDownLatchDemo {

    CountDownLatch latch = new CountDownLatch(3);

    public void teacher() {

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "开始上课");
    }

    public void student() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "准备上课");
        latch.countDown();

    }


    public static void main(String[] args) {
        final CountDownLatchDemo demo = new CountDownLatchDemo();
        new Thread(demo::teacher, "Tea").start();
        new Thread(demo::student, "Stu1").start();
        new Thread(demo::student, "Stu2").start();
        new Thread(demo::student, "Stu3").start();
    }

}