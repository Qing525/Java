package rpc.registry;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LJQ
 * @date 2019/7/22 15:05
 * <p>
 * 注册中心，将服务端的接口注册  供客户端调用
 **/
public class RegistryCenter {

    private int port;

    public RegistryCenter(int port) {
        this.port = port;
    }

    ObjectInputStream ois = null;
    ObjectOutputStream out = null;
    Map<String, Class> registryMap = new ConcurrentHashMap<>(16);

    /**
     * 服务端开启服务
     */
    public void start() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        //等待客户端连接
        System.out.println("连接成功");

        //服务端开始接收
        ois = new ObjectInputStream(socket.getInputStream());
        String interfaceName = ois.readUTF();
        String methodName = ois.readUTF();
        Class[] paramType = (Class[]) ois.readObject();
        Object[] args = (Object[]) ois.readObject();

        //根据客户端的请求从 注册中心拿到 接口
        Class realInterface = registryMap.get(interfaceName);
        //拿到接口里的方法
        Method method = realInterface.getMethod(methodName, paramType);
        //执行接口里的方法
        Object result = method.invoke(realInterface.newInstance(), args);
        //将结果返回给客户端
        out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(result);
        out.close();
        ois.close();
        socket.close();
    }

    /**
     * @param service     接口名
     * @param serviceImpl 接口的实现类
     */
    public void registry(Class service, Class serviceImpl) {
        registryMap.put(service.getName(), serviceImpl);
    }

    void stop() {
    }
}
