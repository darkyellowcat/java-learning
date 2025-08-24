package thread.basics;

public class Test1 {
    public static void main(String[] args) {
        //1.创建线程对象
        myThread mt = new myThread();
        //2.启动线程
        mt.start();

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
