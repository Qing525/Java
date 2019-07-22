package socket3;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

/**
 * @author LJQ
 * @date 2019/7/19 17:46
 **/
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9004);
        InputStream inputStream = socket.getInputStream();
        File file=new File("D:\\test\\"+ UUID.randomUUID().toString()+".png");
        OutputStream out =new FileOutputStream(file);
        byte [] bytes =new byte[100];

        while ( inputStream.read(bytes)!=-1) {
            out.write(bytes);
        }
        out.close();
        inputStream.close();
        socket.close();
    }

}
