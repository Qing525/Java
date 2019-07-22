package socket3;

import java.io.*;
import java.net.Socket;

/**
 * @author LJQ
 * @date 2019/7/22 10:28
 **/
public class MutiThread implements Runnable {

    private Socket socket;

    public MutiThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            File file = new File("E:\\study\\Java\\qq.png");
            InputStream in = new FileInputStream(file);
            byte[] bytes = new byte[100];
            while (in.read(bytes) != -1) {
                outputStream.write(bytes);
            }
            in.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // socket.close();

        // server.close();

    }
}
