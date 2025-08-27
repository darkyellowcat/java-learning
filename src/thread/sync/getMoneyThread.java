package thread.sync;

public class getMoneyThread extends Thread {
    private Account account;

    public getMoneyThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account) {
            account.getBalance();
        }
    }
}
