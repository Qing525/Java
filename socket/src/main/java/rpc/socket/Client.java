package rpc.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author LJQ
 * @date 2019/7/22 15:05
 **/
public class Client {

    ObjectOutputStream oos = null;
    ObjectInputStream  ois = null;
    Socket socket =null;
    /**
     * @param Interface 接口
     * @param address   待连接的 服务端的 IP  , port
     * @param <T>       获取代理对象
     * @return
     */
    public <T> T getProxyObject(Class Interface, InetSocketAddress address) throws IOException {

        // proxy 代理对象    method 代理的方法        args 方法的参数
        return (T) Proxy.newProxyInstance(Interface.getClassLoader(), new Class[]{Interface}, (proxy, method, args) -> {
            socket = new Socket();
            socket.connect(address);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeUTF(Interface.getName());
            oos.writeUTF(method.getName());
            //方法的类型
            oos.writeObject(method.getParameterTypes());
            oos.writeObject(args);
            //等待服务端接收
            // 解析服务端返回的结果
            ois = new ObjectInputStream(socket.getInputStream());
            return ois.readObject();
        });
    }

}




