package com.ljq.staticProxy;

/**
 * @author : lijq
 * @date : 2020/4/4 18:20
 * 房东
 */
public class FD implements Rent {

    @Override
    public void rent() {
        System.out.println("我是房东===");
    }
}
