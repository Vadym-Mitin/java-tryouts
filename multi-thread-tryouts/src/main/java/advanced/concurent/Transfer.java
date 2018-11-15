package advanced.concurent;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Vadym Mitin
 */
public class Transfer implements Callable<Boolean> {

    private final Account from;
    private final Account to;
    private final int amount;
    private static final int WAIT_SEC = 3;

    public Transfer(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {

        if (from.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (from.getBalance() < amount)
                    throw new InsufficientFundsException("balance: " + from.getBalance() + "; amount: " + amount);
                if (to.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("transfer: " + amount);
                        from.withdraw(amount);
                        to.deposit(amount);

                        Thread.sleep(new Random().nextInt(WAIT_SEC * 1000));

                        return true;
                    } finally {
                        to.getLock().unlock();
                    }
                } else {
                    to.incFallCounter();
                    System.out.println("deadlock to");
                    return false;
                }
            }
//            catch (InsufficientFundsException e) {
//                e.printStackTrace();
//                return false;
//            }
            finally {
                from.getLock().unlock();
            }
        } else {
            from.incFallCounter();
            System.out.println("deadlock from");
            return false;
        }
    }
}
