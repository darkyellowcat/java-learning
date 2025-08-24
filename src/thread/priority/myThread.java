package thread.priority;

public class myThread extends Thread {
    public myThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++){
            System.out.println(super.getName()+"---"+i);
        }
    }

}
