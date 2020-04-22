package com.ljq.staticProxy;

/**
 * @author : lijq
 * @date : 2020/4/4 18:21
 */
public class DL implements Rent {
    public DL(FD fd) {
        this.fd = fd;
    }
    private FD fd;

    @Override
    public void rent() {
        see();
        fd.rent();
    }

    public void  see(){
        System.out.println("看房");
    }
}
