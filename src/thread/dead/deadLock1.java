package thread.dead;

public class deadLock1 extends  Thread {
    @Override
    public void run() {
        synchronized (resourseObject.object1) {
            System.out.println("Thread 1: Holding object 1...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1: Waiting for object 2...");
            synchronized (resourseObject.object2) {
                System.out.println("Thread 1: Acquired object 2!");
            }
        }
    }
}
