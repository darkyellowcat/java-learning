package thread.dead;

public class deadLock2 extends  Thread {
    @Override
    public void run() {
        synchronized (resourseObject.object2) {
            System.out.println("Thread 2: Holding object 2...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2: Waiting for object 1...");
            synchronized (resourseObject.object1) {
                System.out.println("Thread 2: Acquired object 1!");
            }
        }
    }
}
