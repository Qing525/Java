package com.ljq;

/**
 * @author : lijq
 * @date : 2020/4/13 12:49
 */
public class Sync {
    private static int count = 0;

    private Object o = new Object();

    static synchronized void add() {
        count++;
        System.out.println(Thread.currentThread().getName()+ count);
    }

    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
                Sync.add();
            }).start();
        }
    }

}
