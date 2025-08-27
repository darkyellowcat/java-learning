package online.UDP.chatOnline;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class sendThread extends  Thread {
    private DatagramSocket socket;

    public  sendThread(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String msg = sc.nextLine();
                byte[] data = msg.getBytes();
                // 发送数据
                 DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 7000);
                 socket.send(packet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
