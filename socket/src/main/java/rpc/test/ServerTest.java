package rpc.test;

import rpc.registry.RegistryCenter;
import rpc.service.HelloService;
import rpc.service.impl.HelloServiceImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author LJQ
 * @date 2019/7/22 17:01
 **/
public class ServerTest {
    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        RegistryCenter registryCenter=new RegistryCenter(9999);
      registryCenter.registry(HelloService.class, HelloServiceImpl.class);
      registryCenter.start();
    }
}
