package thread.sync;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void getBalance() {
        if (balance <= 0) {
            System.out.println("Insufficient funds, cannot withdraw.");
            return;
        }
        System.out.println("Current balance: " + balance);
        this.balance -= 100;
        System.out.println("Balance after withdrawal: " + balance);
    }
}
