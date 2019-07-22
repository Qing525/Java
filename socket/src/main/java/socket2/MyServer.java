package socket2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LJQ
 * @date 2019/7/19 17:44
 **/
public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9001);
        Socket socket = server.accept();
        System.out.println("连接成功");
        OutputStream outputStream = socket.getOutputStream();
        File file = new File("E:\\study\\Java\\qq.png");
        InputStream in =new FileInputStream(file);
        byte [] bytes =new byte[100];
        while (in.read(bytes)!=-1){
        outputStream.write(bytes);
    }
        in.close();
        outputStream.close();
        socket.close();
        server.close();
    }
}
