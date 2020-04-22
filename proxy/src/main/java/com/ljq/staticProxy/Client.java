package com.ljq.staticProxy;

/**
 * @author : lijq
 * @date : 2020/4/4 18:24
 */
public class Client {
    public static void main(String[] args) {
        FD fd = new FD();
        DL dl = new DL(fd);
        dl.rent();
    }
}
