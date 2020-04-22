package socketdemo1;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author : lijq
 * @date : 2020/4/5 17:38
 */
public class Client {
    public static void main(String[] args) {

        try (
                Socket socket = new Socket("localhost", 9999);
                OutputStream os = socket.getOutputStream();
        ) {
            os.write("Hello".getBytes());

            IOUtils.write("xx".getBytes(),os);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
