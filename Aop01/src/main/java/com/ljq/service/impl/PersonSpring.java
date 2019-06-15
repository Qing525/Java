package com.ljq.service.impl;

import com.ljq.service.Speakable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author : LJQ
 * @date : 2019/6/3 14:28
 */
@Service
public class PersonSpring implements Speakable {
    @Override
    public void sayHi() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hi");
    }

    @Override
    public void sayBye() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Bye");
    }
}
