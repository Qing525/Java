package com.ljq.lock;

/**
 * @author : lijq
 * @date : 2019/12/16 14:53
 */
public class TicketDemo implements Runnable {

    private Integer num = 10000;

    @Override
    public void run() {

        while (true) {
            synchronized (TicketDemo.class){
            if (num > 0) {
                num--;
                System.out.println(Thread.currentThread().getName() + "卖出第" + (10000 - num) + "张");
            } else {
                break;
            }
            }
        }
    }
}
