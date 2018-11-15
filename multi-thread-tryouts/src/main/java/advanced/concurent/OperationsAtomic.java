package advanced.concurent;

import java.util.concurrent.TimeUnit;

/**
 * @author Vadym Mitin
 */
public class OperationsAtomic {

    private static final int WAIT_SEC = 1;

    public static void main(String[] args) throws InterruptedException {
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
        System.out.println(a.getFallCounter() + " / " + b.getFallCounter());

    }

    private static void transfer(Account from, Account to, int amount) throws InsufficientFundsException, InterruptedException {

        if (from.getBalance() < amount)
            throw new InsufficientFundsException();

        if (from.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (to.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("start transfer ");


                        from.withdraw(amount);
                        to.deposit(amount);

                    } finally {
                        to.getLock().unlock();
                    }
                } else to.incFallCounter();
            } finally {
                from.getLock().unlock();
            }
        } else from.incFallCounter();
    }

}
