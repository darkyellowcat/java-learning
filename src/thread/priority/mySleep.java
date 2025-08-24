package thread.priority;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mySleep {
    public class myThread extends Thread {
        @Override
        public void run() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(sdf.format(date));
        }
    }
    public static void main(String[] args) {
        mySleep ms = new mySleep();
        myThread mt = ms.new myThread();
        mt.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
