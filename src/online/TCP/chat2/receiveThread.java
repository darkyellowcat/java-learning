package online.TCP.chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class receiveThread extends Thread{
    private Socket socket;

    public receiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String content = br.readLine();
                System.out.println("Received from server: " + content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
