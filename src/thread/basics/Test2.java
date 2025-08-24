package thread.basics;

public class Test2 {
    public static void main(String[] args) {
        // 1.创建Runnable接口的实现类对象
        Runnable r = new myRunnable();
        // 2.创建Thread类对象，并将Runnable实现类对象作为参数传入
        Thread t = new Thread(r);
        // 3.启动线程
        t.start();
        for (int j = 1; j < 10; j++) {
            System.out.println("Main Thread is running: " + j);
            try {
                Thread.sleep(1000); // 模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
