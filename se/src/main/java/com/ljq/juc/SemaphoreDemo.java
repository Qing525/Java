package com.ljq.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 控制对某组资源的访问权限
 */
public class SemaphoreDemo {

    static class Work implements Runnable {

        private int no;
        private Semaphore semaphore;

        public Work(int no, Semaphore semaphore) {
            this.no = no;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "获取到锁");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        int total = 8;
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < total; i++) {
            new Thread(new Work(i, semaphore), String.valueOf(i)).start();
        }

    }
}
