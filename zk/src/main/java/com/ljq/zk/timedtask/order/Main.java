package com.ljq.zk.timedtask.order;

import java.util.concurrent.TimeUnit;

/**
 * @author LJQ
 * @date 2019/7/24 16:37
 **/
public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            new Job().start();
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            new PayOrder().start(1L);
        }).start();

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
