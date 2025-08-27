package online.UDP.chatOnline;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class receiveThread extends Thread{
    private DatagramSocket socket;

    public receiveThread(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] data = new byte[1024];
                // 接收数据
                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("收到消息：" + msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
