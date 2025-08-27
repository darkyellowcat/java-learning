package online.TCP.chat1;

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

        Scanner sc = new Scanner(System.in);

        while (true) {
            InputStream isr = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(isr));

            String content = br.readLine();
            System.out.println("Received from client: " + content);

            OutputStream os = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("Server: " + sc.nextLine() + "\n");


            bw.flush();
//        bw.close();
        }

    }
}
