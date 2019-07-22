package socket3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LJQ
 * @date 2019/7/19 17:44
 **/
public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9004);
        while (true){
        Socket socket = server.accept();
        System.out.println("连接成功");
            MutiThread mutiThread = new MutiThread(socket);
new Thread(mutiThread).start();
        }

    }
}
