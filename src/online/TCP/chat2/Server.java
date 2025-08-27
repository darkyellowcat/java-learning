package online.TCP.chat2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // Create a server socket listening on port 8080
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("Server started, waiting for client connections...");
        // Continuously accept client connections
        Socket s = ss.accept();
        System.out.println("Client connected!");

        receiveThread rt = new receiveThread(s);
        rt.start();

        sendThread st = new sendThread(s);
        st.start();

    }
}
