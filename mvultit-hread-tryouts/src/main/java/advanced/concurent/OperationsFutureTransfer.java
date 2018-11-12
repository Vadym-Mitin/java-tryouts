package advanced.concurent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Vadym Mitin
 */
public class OperationsFutureTransfer {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account(1, 2000);
        Account acc2 = new Account(2, 3000);
        Random rnd = new Random();
//        FutureTask<Integer> task = new FutureTask<>();

        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {

            int amount = rnd.nextInt(1000);
            System.out.print(amount + "; ");
            service.submit(new Transfer(acc1, acc2, amount));
        }
        System.out.println();
        System.out.println("end submit");


        service.shutdown();
        service.awaitTermination(2, TimeUnit.MINUTES);

        System.out.println("acc1:  " + acc1.getBalance() + "; " + acc1.getFallCounter());
        System.out.println("acc2:  " + acc2.getBalance() + "; " + acc2.getFallCounter());
    }
}
