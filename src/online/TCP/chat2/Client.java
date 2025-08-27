package online.TCP.chat2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // Create a socket to connect to the server at localhost on port 8080
        Socket socket = new Socket("localhost", 8080);
        ;
        System.out.println("Connected to server!");

        Scanner sc = new Scanner(System.in);

        receiveThread st = new receiveThread(socket);
        st.start();
        sendThread rt = new sendThread(socket);
        rt.start();

    }
}
