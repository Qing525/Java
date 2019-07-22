package socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author LJQ
 * @date 2019/7/19 17:46
 **/
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9001);
        InputStream inputStream = socket.getInputStream();
        byte [] bytes =new byte[100];
        inputStream.read(bytes);
        System.out.println(new String(bytes));

        OutputStream outputStream = socket.getOutputStream();
        String s="hi";
        outputStream.write(s.getBytes());
    }
}
