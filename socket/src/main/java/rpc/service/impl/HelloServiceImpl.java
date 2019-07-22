package rpc.service.impl;

import rpc.service.HelloService;

/**
 * @author LJQ
 * @date 2019/7/22 15:03
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "hi,"+name;
    }
}
