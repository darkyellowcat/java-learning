package thread.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class readVedio extends Thread{
    // 线程安全的计数器
    private static AtomicInteger count = new AtomicInteger(0);

    // 缓冲区
    private BlockingQueue<Vedio> queue;

    public  readVedio(BlockingQueue<Vedio> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            Vedio vedio = new Vedio(""+count.incrementAndGet());
        }
    }
}
