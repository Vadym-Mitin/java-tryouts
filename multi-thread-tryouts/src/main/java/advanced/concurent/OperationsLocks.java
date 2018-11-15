package advanced.concurent;

import sun.plugin.dom.exception.InvalidStateException;

import java.util.concurrent.TimeUnit;

/**
 * @author Vadym Mitin
 */
public class OperationsLocks {

    private static final int WAIT_SEC = 1;

    public static void main(String[] args) throws InsufficientFundsException, InterruptedException {
        final Account a = new Account(1, 1000);
        final Account b = new Account(2, 2000);

        Thread thread = new Thread(() -> {
            try {
                System.out.println("thread 1 start");
                transfer(a, b, 600);

            } catch (InsufficientFundsException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("thread 2 start");
                transfer(b, a, 300);
            } catch (InsufficientFundsException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();


        System.out.println("a = " + a.getBalance());
        System.out.println("b = " + b.getBalance());

    }

    private static void transfer(Account withdraw, Account deposit, int amount) throws InsufficientFundsException, InterruptedException {
        if (withdraw.getBalance() < amount)
            throw new InsufficientFundsException();


        if (withdraw.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (deposit.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("start transfer ");

                        withdraw.withdraw(amount);
                        deposit.deposit(amount);
                    } finally {
                        deposit.getLock().unlock();
                    }
                } else System.out.println("deposit cant lock");
            } finally {
                withdraw.getLock().unlock();
            }
        } else System.out.println("withdraw cant lock");
    }

}
