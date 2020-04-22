package com.ljq.juc;


import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 一组线程等待至某个状态后同时执行
 */
public class CyclicBarrierDemo {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public void test() {
        System.out.println(Thread.currentThread().getName() + "准备完毕");
        try {
            TimeUnit.SECONDS.sleep(2);
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(new Date());
    }


    public static void main(String[] args) {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();

        new Thread(demo::test, "线程1").start();
        new Thread(demo::test, "线程2").start();
        new Thread(demo::test, "线程3").start();

    }
}
