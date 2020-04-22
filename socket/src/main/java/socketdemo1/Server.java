package socketdemo1;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : lijq
 * @date : 2020/4/5 17:45
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
//        int len;
//
//        while ((len = is.read(bytes)) != -1) {
//           is.read(bytes,0,len);
//        }

        IOUtils.read(is,bytes);
        System.out.println(new String(bytes));
    }
}
