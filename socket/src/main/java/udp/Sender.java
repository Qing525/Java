package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @author : lijq
 * @date : 2020/4/5 19:53
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入===");
            String msg = sc.next();
            DatagramPacket p = new DatagramPacket(msg.getBytes(), 0, msg.length(), new InetSocketAddress("localhost", 9999));
            socket.send(p);
            if("bye".equals(msg.trim())){
                break;
            }
        }
    }
}
