package thread.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {
    public static void main(String[] args) {
        Vedio vedio = new Vedio("Test Video");
        System.out.println("Video name: " + vedio.getName());

        BlockingDeque<Vedio> blockingDeque = new LinkedBlockingDeque<>();

        readVedio reader1 = new readVedio(blockingDeque);
        readVedio reader2 = new readVedio(blockingDeque);
        readVedio reader3 = new readVedio(blockingDeque);

        sendVedio sender1 = new sendVedio(blockingDeque);
        sendVedio sender2 = new sendVedio(blockingDeque);

        reader1.start();
        reader2.start();
        reader3.start();
        sender1.start();
        sender2.start();
    }
}
