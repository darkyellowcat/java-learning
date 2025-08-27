package thread.sync;

public class Test {
    public static void main(String[] args) {
        Account account = new Account(100);

        getMoneyThread t1 = new getMoneyThread(account);
        getMoneyThread t2 = new getMoneyThread(account);

        t1.start();
        t2.start();
    }
}
