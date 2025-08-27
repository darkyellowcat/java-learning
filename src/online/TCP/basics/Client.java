package online.TCP.basics;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // Create a socket to connect to the server at localhost on port 8080
        Socket socket = new Socket ("localhost",8080);;
        System.out.println("Connected to server!");

        // Send a message to the server
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write("Hello, Server!");

        bw.newLine();

        // Flush and close the output stream
        bw.flush();
//        os.close();

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String content = br.readLine();
        System.out.println("Received from server: " + content);
    }
}
