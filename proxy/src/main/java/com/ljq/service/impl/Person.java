package com.ljq.service.impl;

import java.util.concurrent.TimeUnit;

/**
 * @author : LJQ
 * @date : 2019/6/3 17:15
 */
public class Person {

    public void sayHi() {
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Hi----");
    }


    public void sayBye() {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Bye---");

    }
}
