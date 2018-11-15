package tryouts.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vadym Mitin
 */
public class TryoutConditions {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static volatile int account = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread1(i).start();
            new Thread2(i).start();
        }

    }


    static class Thread1 extends Thread {
        int name;

        public Thread1(int name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("thread 1 / " + name + " start");

            lock.lock();
            try {
                System.out.println("Thread 1 / " + name + " work");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account += 10;
            condition.signal();
            System.out.println("Thread 1 / " + name + " add; account = " + account);
            lock.unlock();

        }
    }

    static class Thread2 extends Thread {
        int name;

        public Thread2(int name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("thread 2 / " + name + " start");

            lock.lock();
            if (account < 9) {
                try {
                    System.out.println("Thread 2 / " + name + "  account = " + account + " wait");
                    condition.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            account -= 10;
            System.out.println("Thread 2 / " + name + " withdraw; account = " + account);
            lock.unlock();
        }
    }
}
