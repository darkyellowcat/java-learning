package thread.dead;

public class Test {
    public static void main(String[] args) {
        deadLock1 t1 = new deadLock1();
        deadLock2 t2 = new deadLock2();
        t1.start();
        t2.start();
    }
}
