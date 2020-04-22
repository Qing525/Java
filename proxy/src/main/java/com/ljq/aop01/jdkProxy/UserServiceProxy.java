package com.ljq.aop01.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : lijq
 * @date : 2020/4/5 10:57
 */
public class UserServiceProxy implements InvocationHandler {
    private Object target;

    public UserServiceProxy(Object target) {
        this.target = target;
    }

    public Object getProxy(){
      return   Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String name = method.getName();
        System.out.println("使用了["+name+"]方法");
        Object invoke = method.invoke(target,args);
        System.out.println(1);
        return invoke;
    }
}
