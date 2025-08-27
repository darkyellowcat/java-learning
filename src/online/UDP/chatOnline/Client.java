package online.UDP.chatOnline;

import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        System.out.println("请输入客户端端口号：");
        Scanner sc = new Scanner(System.in);

        int port = Integer.parseInt(sc.nextLine());

        DatagramSocket socket = new DatagramSocket(port);
        byte[] buf = "新用户上线".getBytes();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 7000);
        try {
            socket.send(dp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new sendThread(socket).start();
        new  receiveThread(socket).start();
    }
}
