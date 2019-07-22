package rpc.test;

import rpc.service.HelloService;
import rpc.socket.Client;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author LJQ
 * @date 2019/7/22 17:04
 **/
public class ClientTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Client client=new Client();
        HelloService helloService = client.getProxyObject(Class.forName("rpc.service.HelloService"), new InetSocketAddress("127.0.0.1", 9999));
        String s = helloService.sayHi("zs");
        System.out.println(s);
    }
}
