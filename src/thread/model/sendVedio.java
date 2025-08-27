package thread.model;

import java.util.concurrent.BlockingQueue;

public class sendVedio extends  Thread{
    private BlockingQueue<Vedio> queue;
    public sendVedio(BlockingQueue<Vedio> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Vedio vedio = queue.take(); // 从队列中取出视频
                System.out.println("Sending video: " + vedio.getName());
                // 模拟发送视频的耗时操作
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
