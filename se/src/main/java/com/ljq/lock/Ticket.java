package com.ljq.lock;

import java.util.concurrent.TimeUnit;

class ShareData {
    private Integer num = 100000;

    public synchronized void sell() {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        while (true) {
            if (num > 0) {
                num--;

                System.out.println(Thread.currentThread().getName() + "卖出第" + (100000 - num) + "张");
            }
//            if (num == 0) {
//
//                System.out.println("卖票终止");
//            }
        }

    }
}

public class Ticket {
    public static void main(String[] args) {
        ShareData data = new ShareData();
        new Thread(() -> {
            data.sell();
        }, "AA").start();
        new Thread(() -> {
            data.sell();
        }, "BB").start();
        new Thread(() -> {
            data.sell();
        }, "CC").start();


    }
}
