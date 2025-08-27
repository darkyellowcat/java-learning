package online.UDP.chatOnline;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(7000);

        List<HashMap<String, String>> list = new ArrayList<>();

        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            socket.receive(dp);

            String ip = dp.getAddress().getHostAddress();
            String port = dp.getPort() + "";

            for (HashMap<String, String> map : list) {
                if (map.get("ip").equals(ip) && map.get("port").equals(port)) {
                    System.out.println("该客户端已连接，无需重复连接");
                    return;
                }
            }
            HashMap<String, String> map = new HashMap<>();
            map.put("ip", ip);
            map.put("port", port);
            list.add(map);

            for (HashMap<String, String> m : list) {
                if (m.get("ip").equals(ip) && m.get("port").equals(port)) {
                    continue;
                } else {
                    DatagramPacket dp2 = new DatagramPacket(buf, dp.getLength(), InetAddress.getByName(m.get("ip")), Integer.parseInt(m.get("port")));
                    socket.send(dp2);
                }
            }

            DatagramPacket dp2 = new DatagramPacket(buf, dp.getLength(), dp.getAddress(), dp.getPort());
            System.out.println("收到客户端连接：" + new String(dp2.getData(), 0, dp2.getLength()) + " " + dp2.getAddress() + " " + dp2.getPort());
        }
    }
}
