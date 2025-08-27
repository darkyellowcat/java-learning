package online.URL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) throws IOException {
        // 1. Create a URL object
        URL url = null;
        // 2. Open a connection to the URL
        URLConnection urlConnection = url.openConnection();
        // 3. Get the input stream from the connection
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("Photo.png");

        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();

        System.out.println("Download complete!");
    }
}
