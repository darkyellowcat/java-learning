package online.TCP.chat2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class sendThread extends  Thread {
    private Socket socket;

    public  sendThread(Socket socket) {
        this.socket = socket;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            try {
                OutputStream os = socket.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                bw.write("Server: " + sc.nextLine());
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
