package advanced.concurent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.youtube.com/watch?annotation_id=annotation_353278&feature=iv&index=1&list=SP6jg6AGdCNaXo06LjCBmRao-qJdf38oKp&src_vid=g7ynfDFoCL4&v=s032s29-NUU
 *
 * @author Vadym Mitin
 */
public class Account {
    private final int id;
    private int balance;
    private final Lock lock = new ReentrantLock();
    private AtomicInteger fallCounter = new AtomicInteger(0);

    public Account(int accountId, int initialBalance) {
        this.id = accountId;
        this.balance = initialBalance;
    }

    public int getFallCounter() {
        return fallCounter.get();
    }

    public void incFallCounter() {
        fallCounter.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public Lock getLock() {
        return lock;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

}
