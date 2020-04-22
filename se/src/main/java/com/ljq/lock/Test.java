package com.ljq.lock;

/**
 * @author : lijq
 * @date : 2019/12/16 14:57
 */
public class Test {
    public static void main(String[] args) {
        TicketDemo demo=new TicketDemo();

        Thread t1=new Thread(demo,"A");

        Thread t2=new Thread(demo,"B");
        Thread t3=new Thread(demo,"C");
    t1.start();
    t2.start();
    t3.start();

    }


}
