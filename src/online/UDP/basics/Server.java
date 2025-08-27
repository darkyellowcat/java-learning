package online.UDP.basics;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8080);
        System.out.println("Server started on port 8080...");

        while (true) {
            // 准备接收数据包
            byte[] receiveBuf = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuf, receiveBuf.length);

            socket.receive(receivePacket);
            String content = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from client: " + content);

            // 获取客户端地址和端口用于回复
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            // 发送回复
            byte[] sendBuf = "hello client".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, clientAddress, clientPort);
            socket.send(sendPacket);
            System.out.println("Sent to client: hello client");
        }
    }
}