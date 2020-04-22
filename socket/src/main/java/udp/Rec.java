package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author : lijq
 * @date : 2020/4/5 19:55
 */
public class Rec {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket p = new DatagramPacket(bytes, 0, bytes.length);
            socket.receive(p);
            System.out.println(new String(p.getData()));
        }
    }
}
