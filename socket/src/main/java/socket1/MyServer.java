package socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        System.out.println(1);
        OutputStream outputStream = socket.getOutputStream();
        String  info ="hello";
        outputStream.write(info.getBytes());
        InputStream inputStream = socket.getInputStream();
        byte [] bytes =new byte[100];
        inputStream.read(bytes);
        System.out.println(new String(bytes));
    }
}
