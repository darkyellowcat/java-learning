package thread.priority;

public class Test1 {
    public static void main(String[] args) {
        myThread mt1 = new myThread("a");
        myThread mt2 = new myThread("b");
        // 不设置优先级, 默认都是5
        mt1.start();
        mt2.start();
        // 设置优先级
        mt1.setPriority(Thread.MIN_PRIORITY);
        mt2.setPriority(Thread.MAX_PRIORITY);
    }
}
