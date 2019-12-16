package com.ljq.service.impl;

import com.ljq.service.Speakable;

import java.util.concurrent.TimeUnit;

/**
 * @author : LJQ
 * @date : 2019/6/3 15:24
 */
public class PersonImpl implements Speakable {
    @Override
    public void sayHi() {
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Hi----");
    }

    @Override
    public void sayBye() {
try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Bye---");

    }
}
