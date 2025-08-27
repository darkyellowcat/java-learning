package online.UDP.basics;

import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(7080);

        // 设置服务器地址和端口
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 8080;

        // 发送消息到服务器
        byte[] sendBuf = "hello server".getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, serverAddress, serverPort);
        socket.send(sendPacket);
        System.out.println("Sent to server: hello server");

        while (true) {
            // 准备接收数据包
            byte[] receiveBuf = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuf, receiveBuf.length);

            socket.receive(receivePacket);
            String content = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + content);

            // 可选：可以在这里发送回复
            Thread.sleep(1000); // 避免太快循环
        }
    }
}