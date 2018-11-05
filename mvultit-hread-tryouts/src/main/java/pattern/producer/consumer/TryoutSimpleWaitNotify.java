package pattern.producer.consumer;

import java.util.Scanner;

/**
 * @author Vadym Mitin
 */
public class TryoutSimpleWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Worker wk = new Worker();

        Thread thread = new Thread(() -> {

            try {
                wk.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread thread1 = new Thread(() -> {

            try {
                wk.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }

    private static class Worker {
        private Object lock = new Object();

        private void producer() throws InterruptedException {
            synchronized (lock) {
                System.out.println("Producer is started, and begin to wait");
                lock.wait();
                System.out.println("Producer is continue");
            }
        }

        private void consumer() throws InterruptedException {
            Thread.sleep(1500);
            Scanner sc = new Scanner(System.in);
            synchronized (lock) {
                System.out.println("wait for pressed key");
                sc.nextLine();
                System.out.println("notified the previous thread");

                // start previous thread
                lock.notify();
            }
        }
    }
}
