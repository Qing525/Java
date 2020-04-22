package socketdemo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : lijq
 * @date : 2020/4/5 17:45
 */
public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();
//        FileOutputStream fos = new FileOutputStream("2.png");
//
//
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = is.read(bytes)) != -1) {
//            fos.write(bytes,0,len);
//        }

        FileUtils.copyInputStreamToFile(is,new File("3.png"));
    }
}
