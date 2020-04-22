package socketdemo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author : lijq
 * @date : 2020/4/5 17:38
 */
public class FileClient {
    public static void main(String[] args) {

        try (
                Socket socket = new Socket("localhost", 9999);
                OutputStream os = socket.getOutputStream();
        ) {
            //      FileInputStream  fis=new FileInputStream( new File(""));
            //   InputStream is =  FileClient.class.getClassLoader().getResourceAsStream("1.png");

            String file = FileClient.class.getClassLoader().getResource("1.png").getFile();
//            FileInputStream fis = new FileInputStream(new File(file));

            FileUtils.copyFile(new File(file),os);
        socket.shutdownOutput();
//            byte[] bytes = new byte[1024];
//            int len;
//            while ((len = fis.read(bytes)) != -1) {
//                os.write(bytes, 0, len);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
