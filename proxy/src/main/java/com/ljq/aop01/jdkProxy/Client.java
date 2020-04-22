package com.ljq.aop01.jdkProxy;

/**
 * @author : lijq
 * @date : 2020/4/5 11:04
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy proxy=new UserServiceProxy(userService);

        UserService proxy1 = (UserService)proxy.getProxy();
        proxy1.update();
    }
}
