package com.ljq.aop01.jdkProxy;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author : lijq
 * @date : 2020/4/5 10:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add(String msg) {
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("添加了一个用户"+msg);
    }

    @Override
    public void update() {
        System.out.println("修改了一个用户");
    }

    @Override
    public void select() {

    }

    @Override
    public void delete() {

    }
}
