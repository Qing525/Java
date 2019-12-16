package com.ljq.service;

import com.ljq.service.impl.Person;
import com.ljq.service.impl.PersonImpl;

/**
 * @author : LJQ
 * @date : 2019/6/3 15:30
 * 工厂类
 */
public class PersonProxyFactory {
    public static Speakable newJdkProxy() {
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonImpl());
        Speakable proxy = dynamicProxy.getProxy();
        return proxy;
    }

    public static Person newCglibProxy(){

        return CGLibProxy.getInstance().getProxy(Person.class);
    }
}
