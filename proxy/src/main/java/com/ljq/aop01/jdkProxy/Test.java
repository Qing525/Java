package com.ljq.aop01.jdkProxy;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author : lijq
 * @date : 2020/4/5 11:12
 */
public class Test implements InvocationHandler {
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return null;
    }
}
